# TECHSTORE PRODUCT MANAGEMENT SYSTEM

## 📖Project Description
TechStore Product Management System is a desktop application developed to help electronics stores manage their inventory efficiently. 
The main goal of this project is to give full control to the users. Instead of just viewing a static list, the store staff can actively manage the stock by adding new items and removing sold products.

The system is built using **Java** and the **Swing** library for the graphical user interface. It organizes electronic devices into three main categories: **Laptops**, **Smartphones**, and **Tablets**.

To ensure security, the application uses a login system with two different access levels:
* **Manager:** Has full authority. A manager can add new products, delete existing ones, search for specific items, and display the entire inventory.
* **Staff:** Has limited access focused on sales. A staff member can delete sold products, search for items, and display the inventory, but cannot add new stock.

## 🛠 Technical Implementation
This project is built using **Java** and strictly follows **Object-Oriented Programming (OOP)** principles. Below are the key technical details:

### 1. Inheritance Hierarchy
We created a main abstract class called `ElectronicDevice`. This class defines the common structure for all products. It holds the following common attributes:
* **Brand**
* **Model**
* **Price**
* **Serial Number**

We have three subclasses derived from this superclass:
* `Laptop`
* `SmartPhone`
* `Tablet`

### 2. Composition (Has-a Relationship)
To make the project more realistic, we used composition. Each device category has a specific component object inside it:
* **Laptop** has a `FanCount` component.
* **SmartPhone** has an `NfcModule` component.
* **Tablet** has a `Pencil` component.

### 3. Interface
We defined an interface named `Warrantity`.
* It includes the `warrantyPeriod(int)` method.
* Selected devices implement this interface to set or update their warranty periods.

### 4. Data Structures & Algorithms
* **Data Management:** All operations are handled by the `SystemClass`.
* **Storage:** We use a dynamic `ArrayList` to store the device objects.
* **Recursion:** We used **recursive methods** to search for products by serial number and to display the list of products.
  
## 🖥️ Graphical User Interface (GUI)
