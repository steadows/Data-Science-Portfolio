# 🏋️ Gym Management Database

[![SQL](https://img.shields.io/badge/SQL-Oracle-blue)](https://www.oracle.com/database/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

The **Gym Management Database** is a relational database system designed to manage daily operations across multiple gym franchises. Developed as a group project for CIS 353 (Fall 2022) at Grand Valley State University, it tracks gym locations, employees, members, classes, and memberships to ensure efficient operations and informed decision-making. The system supports tasks like employee onboarding, class scheduling, membership management, and trend analysis for optimizing gym performance and member experience.

**Team Members**:
- Cymbre Spoehr
- Lauren Inman
- Sam Beals
- Alex Young
- Steve Meadows

## 🎯 Objectives

- **Streamline Operations**: Manage gym locations, employees, members, classes, and memberships efficiently.
- **Ensure Compliance**: Enforce age restrictions for classes and verify employee qualifications.
- **Provide Insights**: Query trends such as popular locations, classes, and trainers to optimize business decisions.
- **Enhance Member Experience**: Track membership tiers, costs, and class enrollments for personalized services.

## 📂 Project Structure

### Files
- **`project1.1.sql`**: Main SQL script to create tables, populate data, and execute queries.
- **`drop.sql`**: SQL script to drop all tables for a clean setup.
- **`Database_Project_Proposal.docx`**: Project proposal detailing requirements, schema, and ER diagram.
- **ER Diagram**: Visual representation of the database schema (included in the proposal).

### Database Schema
The schema includes the following entities and relationships:
- **Location**: Stores gym locations with a unique `locID` and `locName`.
- **LocationAmenities**: Tracks amenities (e.g., Pool, Sauna) available at each location.
- **Employee**: Manages employee details (`ssn`, `name`, `age`, `locID`).
- **Class**: Defines classes with `dateTime`, `locID`, `teacherID`, `title`, `minimumAge`, and `capacity`.
- **Member**: Tracks members with `mID`, `name`, `age`, and `membershipID`.
- **ClassEnrolled**: Records member enrollments in classes.
- **Membership**: Manages memberships with `membershipID`, `costPerMonth`, `tier`, and `paymentInfo`.
- **Commission**: Tracks commissions earned by employees for selling memberships.

#### Relationships
- **Hosts**: Location hosts Classes (1:N).
- **Works At**: Employee works at Location (N:M).
- **Teaches**: Employee teaches Class (N:1, total participation from Class).
- **Enrolls In**: Member enrolls in Class (N:M).
- **Uses**: Member uses Membership (N:1).
- **Administers**: Employee administers Membership for commission (N:1).

## 📊 ER Diagram

The ER diagram (from the proposal) outlines the relationships between entities, including attributes like `minimumAge` for classes, `tier` for memberships, and `comissionAmt` for employees. Key simplifications from the proposal include removing address attributes, eliminating the `Dependent` entity, and treating amenities as a multivalue attribute.

## 🛠️ Setup and Installation

### Prerequisites
- **Oracle SQL**: Compatible database system for executing scripts.
- **SQL Client**: SQL*Plus or a similar tool to run SQL scripts.

