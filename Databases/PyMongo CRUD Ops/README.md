# 🚗 Electric Vehicle Database Management

[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![MongoDB](https://img.shields.io/badge/MongoDB-4.0+-green)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

The **Electric Vehicle Database Management** project is a Python application that interacts with a MongoDB database to manage electric vehicle (EV) records. It provides a command-line interface (CLI) for users to perform CRUD operations (Create, Read, Update, Delete) on vehicle data, as well as aggregate queries to analyze trends. The system is designed to store and manipulate detailed EV information, such as VIN, make, model, electric range, and geographic data, making it useful for EV researchers, dealerships, or enthusiasts.

## 🎯 Objectives

- **Manage EV Data**: Perform CRUD operations on electric vehicle records in a MongoDB database.
- **Analyze Trends**: Use aggregation to explore data distributions (e.g., count of vehicles by make or state).
- **User-Friendly Interface**: Provide an interactive CLI for easy data management.
- **Scalable Design**: Leverage MongoDB's NoSQL structure for flexible data storage and querying.

## 📂 Project Structure

### Files
- **`Mongo_Client.py`**: Main Python script containing the `ElectricVehicle` class, database operations, and CLI interface.

### Data Schema
The `ElectricVehicle` class defines the structure of each vehicle record with the following attributes:
- `VIN (1-10)`: Vehicle Identification Number (first 10 characters).
- `County`, `City`, `State`, `Postal Code`: Geographic location of the vehicle.
- `Model Year`, `Make`, `Model`: Vehicle details.
- `Electric Vehicle Type`: Type of EV (e.g., BEV, PHEV).
- `Clean Alternative Fuel Vehicle (CAFV) Eligibility`: Eligibility for CAFV status.
- `Electric Range`, `Base MSRP`: Range and price of the vehicle.
- `Legislative District`, `DOL Vehicle ID`, `Vehicle Location`: Registration and location details.
- `Electric Utility`, `2020 Census Tract`: Utility provider and census data.

Records are stored as JSON-like documents in a MongoDB collection named `EVs` under the database `Electric-Vehicles`.

## 📊 Features

- **Look Up Vehicle**: Search for a vehicle by VIN and display its details.
- **Insert Vehicle**: Add a new vehicle record to the database.
- **Update Vehicle**: Modify a specific field of an existing vehicle record.
- **Delete Vehicle**: Remove a vehicle record by VIN.
- **Get Aggregate**: Perform aggregation to count occurrences of a specified attribute (e.g., number of vehicles by make).

## 🛠️ Setup and Installation

### Prerequisites
- **Python**: 3.8 or higher.
- **MongoDB**: 4.0 or higher, running on `localhost:27017`.
- **PyMongo**: Python driver for MongoDB.

### Installation
1. Clone or download the project repository.
2. Install the required Python package:
   ```bash
   pip install pymongo