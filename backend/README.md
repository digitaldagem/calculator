# Calculator Application's Backend Server

## Database

The project uses an in-memory H2 db for tests and a Mysql db when running.

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
  "result": "2"
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
  "result": "0"
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
  "result": "1"
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
  "result": "2"
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
    "firstValue": "2", 
    "operatorSign": "÷",
    "secondValue": "1",
    "result": "2"
  },
  {
    "firstValue": "-1",
    "operator": "*",
    "secondValue": "1",
    "result": "-1"
  },
  {
    "firstValue": "7",
    "operatorSign": "÷",
    "secondValue": "2",
    "result": "3.5"
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
