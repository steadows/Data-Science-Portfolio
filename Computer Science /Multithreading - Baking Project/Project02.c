/**
 * @author Steve Meadows and Lauren Inman
 * @date 4/7/23
 * CIS 452 Section 3
 * Winter '23
 * Project 2 - Baking Project
 * Professor Bobeldyk
 * @note If you're running in EOS, please compile with 'gcc Project02.c -o Project02 -lpthread'
 * @note I ran without the '-lpthread' tag and it gave me wild kickback.
*/


#include <stdio.h>
#include <string.h>
#include <pthread.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <unistd.h>
#include <semaphore.h>
#include <fcntl.h> 
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <signal.h>

#define NUMRECIPES 5
#define BASKET 7
#define INGREDIENTNAME 16
#define PANTRY 6
#define FRIDGE 3
#define FLOUR 0
#define SUGAR 1
#define YEAST 2
#define BKNGSODA 3
#define SALT 4
#define CINNAMON 5
#define MILK 0
#define EGGS 1
#define BUTTER 2

// pantry struct to hold dry ingredients
typedef struct{
    char *ingredients[PANTRY];
} Pantry;

// fridge struct to hold wet ingredients
typedef struct{
    char *ingredients[FRIDGE];
} Fridge;

// kitchen struct that has a fridge and a pantry
typedef struct{
    Pantry pantry;
    Fridge fridge;
} Kitchen;

// initialize kitchen full of ingredients
Kitchen kitchen = {
    .pantry.ingredients = {"Flour", "Sugar", "Yeast", "Baking Soda", "Salt", "Cinnamon"},
    .fridge.ingredients = {"Milk", "Eggs", "Butter"}
    };

// baker struct
typedef struct{
    int id;
    bool ramsey;    // sets true for ramsey call
    int numRecipes; // number of recipes to make
    char **recipes; // array of recipes for each baker
    char **basket;  // array of ingredients for the baker to put ingredients in from fridge and pantry
} Baker;

// global variables
sem_t mixerSem, pantrySem, fridgeSem, bowlSem, spoonSem, ovenSem;
int rando;
int numBakers;
int randomRecipe;
Baker *bakers;

void sigHandler(int sigNum){
    printf("Process Interrupted. Shutdown initiated.\n");
    // Free dynamically allocated memory
    for (int i = 0; i < numBakers; i++){
        // Free recipes array
        free(bakers[i].recipes);
        // Free basket array
        for (int j = 0; j < BASKET; j++){
            free(bakers[i].basket[j]);
        }
        free(bakers[i].basket);
    }

    // Free bakers array
    free(bakers);

    // Destroy semaphores
    sem_destroy(&mixerSem);
    sem_destroy(&pantrySem);
    sem_destroy(&fridgeSem);
    sem_destroy(&bowlSem);
    sem_destroy(&spoonSem);
    sem_destroy(&ovenSem);

    printf("All allocated memory freed. All Semaphores Destroyed.\n");

    exit(0);
}

// clears the bakers basket of ingredients after they're done
void clearBasket(Baker *baker){
    for (int i = 0; i < BASKET; i++)
        baker->basket[i][0] = '\0';
}

// gordon ramsay thread
void *ramsey(void *arg){
    Baker *baker = (Baker *)arg;
    printf("Gordon Ramsay: STOP, BAKER NUMBER %d\n", baker->id);
    sleep(2);
    printf("Gordon Ramsay: You Idiot! This mixture is completely f*****!\n");
    sleep(2);
    printf("Gordon Ramsay: You need to go back, reset, and try not to f*** this up again!\n");    
    sleep(2);
    printf("Gordon Ramsay: What a shame.\n");    
    sleep(5);
    pthread_exit(NULL);
}

// function that gathers ingredients
void getIngredients(Baker *baker, char *recipe){
    int id = baker->id;

    // if we're making cookies
    if (strcmp(recipe, "Cookies") == 0){

        int total = 4;

        // dry ingredients for cookies

        printf("Baker %d: I'm grabbing %s and %s from the pantry\n", id,
               kitchen.pantry.ingredients[FLOUR], kitchen.pantry.ingredients[SUGAR]);

        sleep(2);

        sem_wait(&pantrySem);

        strcpy(baker->basket[0], kitchen.pantry.ingredients[FLOUR]);
        strcpy(baker->basket[1], kitchen.pantry.ingredients[SUGAR]);

        sem_post(&pantrySem);

        // wet ingredients for cookies

        printf("Baker %d: I'm now grabbing %s and %s from the fridge\n", id,
               kitchen.fridge.ingredients[MILK], kitchen.fridge.ingredients[BUTTER]);

        sem_wait(&fridgeSem);

        strcpy(baker->basket[2], kitchen.fridge.ingredients[MILK]);
        strcpy(baker->basket[3], kitchen.fridge.ingredients[BUTTER]);

        sem_post(&fridgeSem);

        sleep(2);

        printf("Baker %d: I now have ", id);

        for (int i = 0; i < total; i++)
            printf("%s, ", baker->basket[i]);

        printf("in my basket of ingredients\n");

        sleep(2);
    }

    // if we're making pancakes
    else if (strcmp(recipe, "Pancakes") == 0){
        // dry ingredients for pancakes

        int total = 7;

        printf("Baker %d: I'm grabbing %s, %s, %s, and %s from the pantry\n", id,
               kitchen.pantry.ingredients[FLOUR], kitchen.pantry.ingredients[SUGAR],
               kitchen.pantry.ingredients[BKNGSODA], kitchen.pantry.ingredients[SALT]);

        sleep(2);

        sem_wait(&pantrySem);

        strcpy(baker->basket[0], kitchen.pantry.ingredients[FLOUR]);
        strcpy(baker->basket[1], kitchen.pantry.ingredients[SUGAR]);
        strcpy(baker->basket[2], kitchen.pantry.ingredients[BKNGSODA]);
        strcpy(baker->basket[3], kitchen.pantry.ingredients[SALT]);

        sem_post(&pantrySem);

        // wet ingredients for pancakes

        printf("Baker %d: I'm now grabbing %s, %s, and %s from the fridge\n", id,
               kitchen.fridge.ingredients[EGGS], kitchen.fridge.ingredients[MILK],
               kitchen.fridge.ingredients[BUTTER]);

        sem_wait(&fridgeSem);

        strcpy(baker->basket[4], kitchen.fridge.ingredients[EGGS]);
        strcpy(baker->basket[5], kitchen.fridge.ingredients[MILK]);
        strcpy(baker->basket[6], kitchen.fridge.ingredients[BUTTER]);

        sem_post(&fridgeSem);

        sleep(2);

        printf("Baker %d: I now have ", id);

        for (int i = 0; i < total; i++)
            printf("%s, ", baker->basket[i]);

        printf("in my basket of ingredients\n");

        sleep(2);
    }

    // if we're making pizza dough
    else if (strcmp(recipe, "Homemade Pizza Dough") == 0){
        int total = 3;

        // dry ingredients for pizza dough

        printf("Baker %d: I'm grabbing %s, %s, and %s from the pantry\n", id,
               kitchen.pantry.ingredients[YEAST], kitchen.pantry.ingredients[SUGAR],
               kitchen.pantry.ingredients[SALT]);

        sleep(2);

        sem_wait(&pantrySem);

        strcpy(baker->basket[0], kitchen.pantry.ingredients[YEAST]);
        strcpy(baker->basket[1], kitchen.pantry.ingredients[SUGAR]);
        strcpy(baker->basket[2], kitchen.pantry.ingredients[SALT]);

        sem_post(&pantrySem);

        sleep(2);

        printf("Baker %d: I now have ", id);

        for (int i = 0; i < total; i++)
            printf("%s, ", baker->basket[i]);

        printf("in my basket of ingredients\n");

        sleep(2);
    }

    // if we're make pretzels
    else if (strcmp(recipe, "Soft Pretzels") == 0){
        // dry ingredients for pretzels

        int total = 6;

        printf("Baker %d: I'm grabbing %s, %s, %s, %s and %s from the pantry\n", id,
               kitchen.pantry.ingredients[FLOUR], kitchen.pantry.ingredients[SUGAR],
               kitchen.pantry.ingredients[SALT], kitchen.pantry.ingredients[YEAST],
               kitchen.pantry.ingredients[BKNGSODA]);

        sleep(2);

        sem_wait(&pantrySem);

        strcpy(baker->basket[0], kitchen.pantry.ingredients[FLOUR]);
        strcpy(baker->basket[1], kitchen.pantry.ingredients[SUGAR]);
        strcpy(baker->basket[2], kitchen.pantry.ingredients[SALT]);
        strcpy(baker->basket[3], kitchen.pantry.ingredients[YEAST]);
        strcpy(baker->basket[4], kitchen.pantry.ingredients[BKNGSODA]);

        sem_post(&pantrySem);


        // wet ingredients for pretzels

        printf("Baker %d: I'm now grabbing %s from the fridge\n", id,
               kitchen.fridge.ingredients[EGGS]);

        sem_wait(&fridgeSem);

        strcpy(baker->basket[5], kitchen.fridge.ingredients[EGGS]);

        sem_post(&fridgeSem);

        sleep(2);

        printf("Baker %d: I now have ", id);

        for (int i = 0; i < total; i++)
            printf("%s, ", baker->basket[i]);

        printf("in my basket of ingredients\n");

        sleep(2);
    }

    // if we're making cinnamon rolls
    else if (strcmp(recipe, "Cinnamon Rolls") == 0){
        // dry ingredients for cinnamon rolls

        int total = 6;

        printf("Baker %d: I'm grabbing %s, %s, %s, and %s from the pantry\n", id,
               kitchen.pantry.ingredients[FLOUR], kitchen.pantry.ingredients[SUGAR],
               kitchen.pantry.ingredients[SALT], kitchen.pantry.ingredients[CINNAMON]);

        sleep(2);

        sem_wait(&pantrySem);

        strcpy(baker->basket[0], kitchen.pantry.ingredients[FLOUR]);
        strcpy(baker->basket[1], kitchen.pantry.ingredients[SUGAR]);
        strcpy(baker->basket[2], kitchen.pantry.ingredients[SALT]);
        strcpy(baker->basket[3], kitchen.pantry.ingredients[CINNAMON]);

        sem_post(&pantrySem);

        // wet ingredients for cinnamon rolls

        printf("Baker %d: I'm now grabbing %s and %s from the fridge\n", id,
               kitchen.fridge.ingredients[BUTTER], kitchen.fridge.ingredients[EGGS]);

        sem_wait(&fridgeSem);

        strcpy(baker->basket[4], kitchen.fridge.ingredients[BUTTER]);
        strcpy(baker->basket[5], kitchen.fridge.ingredients[EGGS]);

        sem_post(&fridgeSem);

        sleep(2);
        printf("Baker %d: I now have ", id);

        for (int i = 0; i < total; i++)
            printf("%s, ", baker->basket[i]);

        printf("in my basket of ingredients\n");
        sleep(2);
    }
}

// function that mixes ingredients
void mixIngredients(Baker *baker, char *recipe){
    sleep(1);
    printf("Baker %d: Ok, grabing my spoon to make %s\n", baker->id, recipe);
    sem_wait(&spoonSem);
    sleep(2);
    printf("Baker %d: Grabing my bowl to make %s\n", baker->id, recipe);
    sem_wait(&bowlSem);
    sleep(2);
    printf("Baker %d: Now grabing a mixer to make %s\n", baker->id, recipe);
    sem_wait(&mixerSem);
    sleep(2);
    printf("Baker %d: Time to mix it up!!\n", baker->id);
    sleep(2);
    printf("Baker %d: Alright, my %s are mixed. Time to bake!\n", baker->id, recipe);
    sleep(1);
    sem_post(&spoonSem);
    sem_post(&bowlSem);
    sem_post(&mixerSem);
}

// function that bakes the pastry
void bake(Baker *baker, char *recipe){
    sleep(2);
    printf("Baker %d: Alright! Throwing these %s in the oven!\n", baker->id, recipe);
    sem_wait(&ovenSem);
    sleep(5);
    printf("Baker %d: All done! Next chump can use the oven now!\n", baker->id);
    sleep(2);
    sem_post(&ovenSem);
}

// baker thread called from pthread_create call in main
void *bakerThread(void *arg){
    Baker *baker = (Baker *)arg; // stores the baker from argument

    // allows each baker thread to bake each recipe
    for (int i = 0; i < NUMRECIPES; i++){ 
        sleep(2);
        printf("Baker %d: I'm going to make %s!\n", baker->id, baker->recipes[i]);
        sleep(2);
        getIngredients(baker, baker->recipes[i]); // get ingredients function call
        sleep(2);
        printf("Baker %d: Ok, I've got all my ingredients to make %s.\n", baker->id, baker->recipes[i]);
        sleep(2);
        printf("Baker %d: Now I'll grab what I need to mix it all together.\n", baker->id);
        sleep(2);
        mixIngredients(baker, baker->recipes[i]); // mix ingredients function call
        sleep(2);

        /**
         * If the baker has been randomly selected to be ramsied, and the recipe
         * has been randomly selected to be ramsied, the baker has to drop everthing
         * he's doing and start the recipe all over again.
        */
        if (i == randomRecipe && baker->ramsey == 1){ 

            // initializes a new thread for ramsay
            pthread_t *ramseyThread = (pthread_t *) malloc(sizeof(pthread_t)); 
            sleep(2);
            pthread_create(ramseyThread, NULL, ramsey, baker); // creates the thread
            pthread_join(*ramseyThread, NULL); // continues the baker thread after he's done screaming
            free(ramseyThread); // frees the memory created for the thread
            sleep(2);
            clearBasket(baker); // baker throws away his basket of ingredients
            sleep(2);
            getIngredients(baker, baker->recipes[i]); // gathers new for the same recipe
            sleep(2);
            mixIngredients(baker, baker->recipes[i]); // mixes again
            sleep(2);
        }
        bake(baker, baker->recipes[i]); // bake function call
        sleep(2);
        clearBasket(baker); // Clear the basket for the next recipe
    }
    printf("Baker %d has finished.\n", baker->id);
    sleep(2);
    pthread_exit(NULL);
}

int main(){
    signal(SIGINT, sigHandler); // sigint signal installer

    int numBakers; // number of bakers initializer

    // Initialize semaphores
    sem_init(&mixerSem, 0, 2);
    sem_init(&pantrySem, 0, 1);
    sem_init(&fridgeSem, 0, 2);
    sem_init(&bowlSem, 0, 3);
    sem_init(&spoonSem, 0, 5);
    sem_init(&ovenSem, 0, 1);

    printf("Enter the number of bakers: ");
    scanf("%d", &numBakers);

    srand(time(NULL));
    int random = rand() % numBakers + 1; // select random number to assign random baker
    int prob = rand() % 2;               // 50/50 chance to be ramsied
    rando = random;                      // stores number as int
    randomRecipe = rand() % NUMRECIPES;  // selects random recipe should the baker be ramsied

    pthread_t threads[numBakers]; // thread storage

    const char *recipeNames[] = { // list of recipes for bakers
        "Cookies",
        "Pancakes",
        "Homemade Pizza Dough",
        "Soft Pretzels",
        "Cinnamon Rolls"
        };

    // Allocate memory for the bakers array
    Baker *bakers = (Baker *)malloc(numBakers * sizeof(Baker));

    for (int i = 0; i < numBakers; i++){
        bakers[i].id = i + 1;
        // Initialize other properties of the baker

        // Allocate memory for the recipes array for each baker recipe list
        bakers[i].recipes = (char **)malloc(NUMRECIPES * sizeof(char *));
        if (bakers[i].recipes == NULL){
            printf("Memory allocation failed.\n");
            return 1;
        }

        // Allocate memory for the array of pointers to basket items
        bakers[i].basket = (char **)malloc(BASKET * sizeof(char *));
        if (bakers[i].basket == NULL){
            printf("Memory allocation failed.\n");
            return 1;
        }

        // Allocate memory for each individual string
        for (int j = 0; j < BASKET; j++){
            bakers[i].basket[j] = (char *)malloc(INGREDIENTNAME * sizeof(char));
            if (bakers[i].basket[j] == NULL)
            {
                printf("Memory allocation failed for string %d.\n", j);
                return 1;
            }
        }

        // Copy recipe names to the baker's recipe list
        for (int j = 0; j < NUMRECIPES; j++){
            bakers[i].recipes[j] = (char *)recipeNames[j];
        }

        bakers->numRecipes = NUMRECIPES;

        
        /**
         * If the baker id is the same as the thread we're creating, and the coin flip
         * turned out to not be in this baker's favor, we put a target on that baker's 
         * back.
        */
        if (i + 1 == rando && prob < 1){ 
            bakers[i].ramsey = true;
        }
        else{
            bakers[i].ramsey = false;
        }

        pthread_create(&threads[i], NULL, bakerThread, (void *)&bakers[i]); // creates and started the bakers
        sleep(1);
    }

    for (int i = 0; i < numBakers; i++){ // waits for all bakers to be finished.
        pthread_join(threads[i], NULL);
    }

    // Free dynamically allocated memory
    for (int i = 0; i < numBakers; i++){
        // Free recipes array
        free(bakers[i].recipes);

        // Free basket array
        for (int j = 0; j < BASKET; j++){
            free(bakers[i].basket[j]);
        }
        free(bakers[i].basket);
    }

    // Free bakers array
    free(bakers);

    // Destroy semaphores
    sem_destroy(&mixerSem);
    sem_destroy(&pantrySem);
    sem_destroy(&fridgeSem);
    sem_destroy(&bowlSem);
    sem_destroy(&spoonSem);
    sem_destroy(&ovenSem);

    return 0;
}
