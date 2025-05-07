from pymongo import MongoClient

class ElectricVehicle:
    def __init__(self, vin, county, city, state, postal_code, model_year, make, model,
                 electric_vehicle_type, cafv_eligibility, electric_range, base_msrp, legislative_district,
                 dol_vehicle_id, vehicle_location, electric_utility, census_tract):
        self.vin = vin
        self.county = county
        self.city = city
        self.state = state
        self.postal_code = postal_code
        self.model_year = model_year
        self.make = make
        self.model = model
        self.electric_vehicle_type = electric_vehicle_type
        self.cafv_eligibility = cafv_eligibility
        self.electric_range = electric_range
        self.base_msrp = base_msrp
        self.legislative_district = legislative_district
        self.dol_vehicle_id = dol_vehicle_id
        self.vehicle_location = vehicle_location
        self.electric_utility = electric_utility
        self.census_tract = census_tract

    def to_dict(self):
        return {
            "VIN (1-10)": self.vin,
            "County": self.county,
            "City": self.city,
            "State": self.state,
            "Postal Code": self.postal_code,
            "Model Year": self.model_year,
            "Make": self.make,
            "Model": self.model,
            "Electric Vehicle Type": self.electric_vehicle_type,
            "Clean Alternative Fuel Vehicle (CAFV) Eligibility": self.cafv_eligibility,
            "Electric Range": self.electric_range,
            "Base MSRP": self.base_msrp,
            "Legislative District": self.legislative_district,
            "DOL Vehicle ID": self.dol_vehicle_id,
            "Vehicle Location": self.vehicle_location,
            "Electric Utility": self.electric_utility,
            "2020 Census Tract": self.census_tract
        }




# Rest of your code remains unchanged



def display_menu():
    print("\nMenu:")
    print("1. Look up vehicle")
    print("2. Insert vehicle")
    print("3. Update vehicle")
    print("4. Delete vehicle")
    print("5. Get aggregate")
    print("6. Exit")

def look_up_vehicle(collection, vin):
    query = {"VIN (1-10)": vin}
    vehicle = collection.find_one(query)
    if vehicle:
        print("\nVehicle found:")
        for key, value in vehicle.items():
            print(f"{key}: {value}")
    else:
        print("Vehicle not found.")


def insert_vehicle(collection, ev):
    result = collection.insert_one(ev.to_dict())
    inserted_id = result.inserted_id
    print(f"Vehicle inserted successfully with _id: {inserted_id}")


def update_vehicle(collection, vin, field, new_value):
    query = {"VIN (1-10)": vin}
    update_data = {"$set": {field: new_value}}
    result = collection.update_one(query, update_data)
    if result.modified_count > 0:
        print("Vehicle updated successfully.")
    else:
        print("Vehicle not found or no changes made.")

def delete_vehicle(collection, vin):
    query = {"VIN (1-10)": vin}
    result = collection.delete_one(query)
    if result.deleted_count > 0:
        print("Vehicle deleted successfully.")
    else:
        print("Vehicle not found.")

def get_aggregate(collection, attribute):
    pipeline = [
        {"$group": {"_id": f"${attribute}", "count": {"$sum": 1}}}
    ]
    results = collection.aggregate(pipeline)
    print(f"\nAggregate count for each {attribute}:")
    for result in results:
        print(result)

def main():
    # Connect to MongoDB
    client = MongoClient("mongodb://localhost:27017")
    db = client["Electric-Vehicles"]
    collection = db["EVs"]

    while True:
        display_menu()
        choice = input("Enter your choice (1-6): ")

        if choice == "1":
            vin = input("Enter VIN to look up: ")
            look_up_vehicle(collection, vin)
        elif choice == "2":
            ev = ElectricVehicle(
                vin=input("Enter VIN: "),
                county=input("Enter County: "),
                city=input("Enter City: "),
                state=input("Enter State: "),
                postal_code=int(input("Enter Postal Code: ")),
                model_year=int(input("Enter Model Year: ")),
                make=input("Enter Make: "),
                model=input("Enter Model: "),
                electric_vehicle_type=input("Enter Electric Vehicle Type: "),
                cafv_eligibility=input("Enter CAFV Eligibility: "),
                electric_range=int(input("Enter Electric Range: ")),
                base_msrp=int(input("Enter Base MSRP: ")),
                legislative_district=int(input("Enter Legislative District: ")),
                dol_vehicle_id=int(input("Enter DOL Vehicle ID: ")),
                vehicle_location=input("Enter Vehicle Location: "),
                electric_utility=input("Enter Electric Utility: "),
                census_tract=int(input("Enter Census Tract: "))
            )
            insert_vehicle(collection, ev)
        elif choice == "3":
            vin = input("Enter VIN to update: ")
            field = input("Enter field to update: ")
            new_value = input(f"Enter new value for {field}: ")
            update_vehicle(collection, vin, field, new_value)
        elif choice == "4":
            vin = input("Enter VIN to delete: ")
            delete_vehicle(collection, vin)
        elif choice == "5":
            attribute = input("Enter attribute for aggregate: ")
            get_aggregate(collection, attribute)
        elif choice == "6":
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 6.")

    # Close the MongoDB connection
    client.close()

if __name__ == "__main__":
    main()
