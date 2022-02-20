# Calculator Backend Server

## Database

The project currently uses an in-memory H2 db. To change the db to mysql, add the following dependency to the pom.xml file:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>
```
Do not delete the H2 db's dependency since it is being used for testing purposes. Once the Mysql dependency has been added to the pom.xml file, delete the H2 db section of the application.properties file, found in resources, and uncomment out the mysql section. Once you uncomment it out, fill in the following values, `${MYSQL_HOST}, ${MYSQL_ROOT_USERNAME}, ${MYSQL_ROOT_PASSWORD}`, with your values.


## Endpoints

**Endpoint for addition method:**
```http
Post http://localhost:8080/add
```
**Example request json for "add" endpoint:**
```json
{
  "firstValue": 1.0, 
  "operator": "+",
  "secondValue": 1.0
}
```
**Example response json:**
```json
{
  "id": "271b61f8-3566-416b-b2e1-67b48bba92b4",
  "result": 2.0
}
```
<br/>

**Endpoint for subtraction method:**
```http
Post http://localhost:8080/subtract
```
**Example request json for "subtract" endpoint:**
```json
{
  "firstValue": 1.0, 
  "operator": "-",
  "secondValue": 1.0
}
```
**Example response json:**
```json
{
  "id": "471b61f8-3566-416b-b2e1-67b48bba92b4",
  "result": 0.0
}
```
<br/>

**Endpoint for multiplication method:**
```http
Post http://localhost:8080/multiply
```
**Example request json for "multiply" endpoint:**
```json
{
  "firstValue": 1.0, 
  "operator": "*",
  "secondValue": 1.0
}
```
**Example response json:**
```json
{
  "id": "171b61f8-3566-416b-b2e1-67b48bba92b4",
  "result": 1.0
}
```
<br/>

**Endpoint for division method:**
```http
Post http://localhost:8080/divide
```
**Example request json for "divide" endpoint:**
```json
{
  "firstValue": 2.0, 
  "operator": "÷",
  "secondValue": 1.0
}
```
**Example response json:**
```json
{
  "id": "371b61f8-3566-416b-b2e1-67b48bba92b4",
  "result": 2.0
}
```
<br/>

**Endpoint for retrieving history list of operations method:**
```http
Get http://localhost:8080
```
**Example response json:**
```json
[
  {
    "id": "371b61f8-3566-416b-b2e1-67b48bba92b4",
    "firstValue": 2.0, 
    "operator": "÷",
    "secondValue": 1.0,
    "result": 2.0
  },
  {
    "id": "171b61f8-3566-416b-b2e1-67b48bba92b4",
    "firstValue": 1.0,
    "operator": "*",
    "secondValue": 1.0,
    "result": 1.0
  },
  {
    "id": "371b61f8-3566-416b-b2e1-67b48bba92b4",
    "firstValue": 2.0,
    "operator": "÷",
    "secondValue": 1.0,
    "result": 2.0
  }
]
```
<br/>

**Endpoint for deleting history list of operations method:**
```http
Get http://localhost:8080/delete_history
```
**Example response json:**
```json
[]
```
