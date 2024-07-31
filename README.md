# Open Library Client

## Overview
This project is a Java client for interacting with the Open Library API. It allows users to search for books using the Open Library API and retrieve search results.

## Features
- Search for books using a query string.
- Retrieve search results including book titles and other metadata.
- Handle various HTTP response codes and errors.

## Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher

## Setup
1. Clone the repository:
    ```sh
    git clone https://github.com/EsdinDev/EsdinLibrary.git
    cd EsdinLibrary
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Running the Application
To run the application, use the following command:
```sh
mvn exec:java -Dexec.mainClass="org.esdindev.Main"