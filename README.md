
#### Hexlet tests and linter status:
[![Actions Status](https://github.com/funnyDevGirl/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/funnyDevGirl/java-project-78/actions)

#### Maintainability:
[![Maintainability](https://api.codeclimate.com/v1/badges/d8447a39b02a73772c93/maintainability)](https://codeclimate.com/github/funnyDevGirl/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/d8447a39b02a73772c93/test_coverage)](https://codeclimate.com/github/funnyDevGirl/java-project-78/test_coverage)

## The Data Validator project is a library with which you can check the correctness of any data.
## Usage example:

```
        var v = new Validator();

        var schema = v.map();

        // Shape allows you to describe validation for the values of each key of the Map object
        // Creating a set of schemes for checking each key of the object being checked
        // The value of each key has its own scheme
        Map<String, BaseSchema> schemas = new HashMap<>();

        // Defining validation schemes for the values of the "firstName" and "lastName" properties
        // firstName must be a string, required to be filled in
        schemas.put("firstName", v.string().required());
        // lastName is required and must contain at least 2 characters
        schemas.put("lastName", v.string().required().minLength(2));

        // Setting up the scheme `MapSchema`
        // Passing the created set of diagrams to the shape() method
        schema.shape(schemas);

        // Checking the objects
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        schema.isValid(human1); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        schema.isValid(human2); // false

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        schema.isValid(human3); // false
```
To run the program, run:

```make dev```

Compile the code:

```make install```