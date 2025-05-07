# 🗄️ Databases Portfolio

[![SQL](https://img.shields.io/badge/SQL-Oracle-blue)](https://www.oracle.com/database/)
[![MongoDB](https://img.shields.io/badge/MongoDB-4.0+-green)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This folder showcases my expertise in **databases** and **data engineering**, developed through coursework and hands-on projects. My work demonstrates proficiency in modeling, designing, implementing, and manipulating databases across various paradigms, including relational, NoSQL, key-value, and graph databases. These projects reflect skills gained from two key courses:

- **Data Engineering Course**: An introduction to information storage, manipulation, retrieval, analysis, and modeling techniques. Topics include database paradigms, data preparation, extract-transform-load (ETL) processes, information pipelines, and large-scale analytics.
- **Databases Course**: The study and application of established principles in modeling, design, implementation, and manipulation of databases using industrial-strength database management systems (DBMS), alongside key DBMS features and services.

My experience spans multiple database technologies, including Oracle SQL, MongoDB, Redis, and Neo4j, as well as integrating MongoDB with AWS S3 for efficient data storage and retrieval.

## 🎯 Purpose

The projects in this portfolio aim to:
- Demonstrate proficiency in designing and implementing databases across different paradigms.
- Showcase skills in data manipulation, querying, and pipeline development.
- Highlight practical applications of DBMS features for real-world scenarios.
- Reflect my ability to integrate databases with cloud storage solutions like AWS S3.

## 📂 Projects

### 🏋️ [Gym Management Database](https://github.com/steadows/Data-Science-Portfolio/tree/main/Databases/Gym%20Management%20Database)
**Technologies**: Oracle SQL  
**Description**: A relational database system to manage gym operations across multiple franchises. Tracks locations, employees, members, classes, and memberships, ensuring efficient operations and compliance with age restrictions and instructor qualifications. Includes complex queries for trend analysis (e.g., popular classes, locations).  
**Key Skills**:
- Database modeling and schema design (ER diagrams, relational schema).
- SQL table creation, data population, and querying (joins, subqueries, aggregations).
- Integrity constraints (primary keys, foreign keys, check constraints).

### 🚗 [Electric Vehicle Database Management](https://github.com/steadows/Data-Science-Portfolio/tree/main/Databases/PyMongo%20CRUD%20Ops)
**Technologies**: MongoDB, Python (PyMongo)  
**Description**: A Python application for managing electric vehicle (EV) records in a MongoDB database. Provides a CLI for CRUD operations (Create, Read, Update, Delete) and aggregation queries to analyze trends (e.g., vehicle counts by make). Additionally, I integrated MongoDB with AWS S3 to store and retrieve vehicle data, enhancing scalability.  
**Key Skills**:
- NoSQL database design and management with MongoDB.
- CRUD operations and aggregation pipelines.
- Integration with AWS S3 for data storage and retrieval.
- Object-oriented programming for structured data handling.

### Additional Experience
- **Redis**: Utilized Redis for high-performance caching and session management in web applications, leveraging its key-value store for fast data retrieval.
- **Neo4j**: Designed and queried graph databases to model relationships, such as social networks or recommendation systems, using Cypher for traversal and pattern matching.
- **ETL Pipelines**: Built extract-transform-load processes to prepare and migrate data across systems, ensuring data consistency and quality for large-scale analytics.

## 🛠️ Setup and Installation

Each project includes its own `README.md` with specific setup instructions. General requirements:
- **Oracle SQL**: For relational database projects (e.g., Gym Management Database).
- **MongoDB**: 4.0 or higher for NoSQL projects (e.g., Electric Vehicle Database).
- **Python**: 3.8 or higher (with PyMongo for MongoDB projects).

Example setup for MongoDB projects:
```bash
pip install pymongo
mongod  # Start MongoDB server
python Mongo_Client.py

🧠 Key Skills Demonstrated

Database Paradigms: Experience with relational (Oracle SQL), NoSQL (MongoDB), key-value (Redis), and graph (Neo4j) databases.
Data Modeling: Designed schemas for relational and NoSQL databases, ensuring scalability and efficiency.
Querying and Analysis: Wrote complex SQL queries (joins, subqueries, aggregations) and MongoDB aggregation pipelines for data insights.
ETL Processes: Developed pipelines for data preparation and migration across systems.
Cloud Integration: Integrated MongoDB with AWS S3 for scalable data storage and retrieval.
DBMS Features: Leveraged integrity constraints, indexing, and transaction management for robust database operations.

🔮 Future Directions

Advanced Analytics: Incorporate machine learning models to predict trends (e.g., gym class attendance, EV adoption rates).
Distributed Systems: Explore distributed database setups using MongoDB sharding or Neo4j clusters.
Performance Optimization: Implement indexing strategies and query optimization for larger datasets.
Web Interfaces: Develop front-end applications to interact with these databases.

👤 Author
Steve MeadowsData Scientist | Database SpecialistGitHub: @SteveMeadowsPortfolio: stevemeadows.com
📜 License
All projects in this folder are licensed under the MIT License. Feel free to use, modify, and share.

This portfolio highlights my ability to design, implement, and manipulate databases across various paradigms, combining academic learning with practical applications in data engineering.```
