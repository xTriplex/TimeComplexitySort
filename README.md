# Time Complexity Sort

This project is a Java application that allows users to input, generate, and sort complexity expressions based on their growth order.

## Features

- **Add Complexity Expressions**: Users can manually add complexity expressions using predefined terms and operators.
- **Generate Random Complexities**: Generate a list of random complexity expressions.
- **Sort Complexity Expressions**: Sort the list of complexity expressions based on their growth order.
- **Clear List**: Clear the list of added complexity expressions.

## Components

### `ComplexityExpression`

This class represents a complexity expression and provides methods to simplify and compare expressions.

### `BottomPanel`

A `JPanel` that contains buttons for generating random complexities, sorting the list, and clearing the list.

### `ComplexityInputPanel`

A `JPanel` that allows users to input complexity expressions manually.

### `RoundedBorder`

A custom border class to create rounded borders for buttons.

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/xTriplex/TimeComplexitySort
    cd TimeComplexitySort
    ```

2. **Compile the project**:
    ```sh
    javac -d bin src/*.java
    ```

3. **Run the application**:
    ```sh
    java -cp bin Main
    ```

## Usage

- **Add Complexity**: Use the input panel to select terms and operators, then click "Add Complexity".
- **Generate Random**: Click the "Generate Random" button to add 10 random complexity expressions.
- **Sort**: Click the "Sort" button to sort the list of complexity expressions.
- **Clear**: Click the "Clear" button to clear the list.

## Dependencies

- Java Development Kit (JDK) 8 or higher
- Swing for GUI components
