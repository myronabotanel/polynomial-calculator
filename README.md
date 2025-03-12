# Polynomial Calculator

## Overview
This Java application is a **Polynomial Calculator** with a graphical user interface (GUI) that allows users to perform various polynomial operations, including addition, subtraction, multiplication, division, derivation, and integration. The GUI is built using Java Swing, and the application follows a well-structured MVC (Model-View-Controller) design.

## Features
- **Addition**: Computes the sum of two polynomials.
- **Subtraction**: Computes the difference between two polynomials.
- **Multiplication**: Multiplies two polynomials together.
- **Division**: Performs polynomial division, returning the quotient and remainder.
- **Derivation**: Computes the derivative of a polynomial.
- **Integration**: Computes the integral of a polynomial.
- **User-Friendly GUI**: Interactive interface for inputting and displaying results.

## Project Structure
```
org.example
│── Main.java               # Entry point of the application
│
├── gui
│   ├── Design.java         # GUI implementation using Java Swing
│   ├── Controller.java     # Handles user interactions and updates the GUI
│
├── logic
│   ├── Operations.java     # Implements polynomial operations
│
├── model
│   ├── Polinom.java        # Represents a polynomial and provides utility functions
```

## Getting Started
### Prerequisites
- **Java 8+**
- **IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java support)**

### Installation & Running
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/polynomial-calculator.git
   ```
2. Open the project in your preferred IDE.
3. Run `Main.java` to start the application.

## Usage
1. Input polynomials in the provided text fields.
2. Select an operation (Addition, Subtraction, etc.).
3. Click the corresponding button to perform the operation.
4. The result is displayed in the designated output area.

## Example
**Input:**
```
P(x) = 3x^3 + 2x^2 - x + 5
Q(x) = x^2 - 4x + 7
```
**Addition Result:**
```
R(x) = 3x^3 + 3x^2 - 5x + 12
```

## Future Improvements
- Implementing support for fractional coefficients.
- Adding support for exporting results as text files.
- Enhancing the UI with a more modern look.

## License
This project is licensed under the MIT License.

---

**Author:** Your Name  
**GitHub:** [Your Profile](https://github.com/your-username/)

