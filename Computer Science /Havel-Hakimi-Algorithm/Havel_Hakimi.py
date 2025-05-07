def Havel_Hakimi(user_input):
  user_input.sort(reverse=True) #sorts degree sequence in non increasing order
  count = user_input[0] #grabs first number in sequence
  for n in user_input: # determines if any degrees are negative and returns False
      if n < 0:
        #print("This is not a degree sequence")  
        return False
  if sum(user_input) == 0: #determines if all degrees are zero and returns True
    #print("This is a degree sequence")
    return True
  elif all(x == 1 for x in user_input) and len(user_input) % 2 != 0: #condition checks if all degrees are 1 and if there's an even number of vertices - if not returns False
    #print (len(user_input))
    #print("This is not a degree sequence")  
    return False
  else:
    del user_input[0] #deletes first number in array
    #print(count)
    sequence=[]
    for n in range(len(user_input)): #creates a new array and adds numbers from the array that was passed
      sequence.append(user_input[n])
    #print(len(sequence))
    if count <= len(sequence): #ensures that there are enough numbers in array to subtract 1 from
      for n in range(count):
        sequence[n] -= 1
    else: #if there isn't, it returns false
      print("F")
      return False
    #print(sequence)
    sequence.sort(reverse=True)
    #print(sequence)
    return Havel_Hakimi(sequence) # recursive call
    
Havel_Hakimi([1,1,1,1])
print(Havel_Hakimi([1,1,1,1]))