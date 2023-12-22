#!/bin/bash

# Check if exactly two arguments are provided
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 <num1> <num2>"
    exit 1
fi

# Assign command-line arguments to variables
num1=$1
num2=$2

# Check if the inputs are valid numbers
if ! [[ $num1 =~ ^[+-]?[0-9]*\.?[0-9]+$ ]] || ! [[ $num2 =~ ^[+-]?[0-9]*\.?[0-9]+$ ]]; then
    echo "Error: Invalid input. Please provide valid numbers."
    exit 1
fi

# Perform arithmetic operations
sum=$(echo "$num1 + $num2" | bc)
difference=$(echo "$num1 - $num2" | bc)
product=$(echo "$num1 * $num2" | bc)

# Check for division by zero
if [ "$num2" = "0" ]; then
    echo "Error: Division by zero is not allowed."
else
    division=$(echo "scale=2; $num1 / $num2" | bc)
fi

# Display the results
echo "Sum: $sum"
echo "Difference: $difference"
echo "Product: $product"

# Display division result only if division by zero is not encountered
if [ -n "$division" ]; then
    echo "Division: $division"
fi
#!/bin/bash

# Check if two arguments are provided
if [ "$#" -ne 2 ]; then
  echo "Usage: $0 <number1> <number2>"
  exit 1
fi

# Check if the arguments are valid numbers
if ! [[ $1 =~ ^[0-9]+(\.[0-9]+)?$ ]] || ! [[ $2 =~ ^[0-9]+(\.[0-9]+)?$ ]]; then
  echo "Error: Please provide valid numeric arguments."
  exit 1
fi

# Assign the command-line arguments to variables
num1="$1"
num2="$2"

# Perform calculations
sum=$(bc <<< "$num1 + $num2")
difference=$(bc <<< "$num1 - $num2")
product=$(bc <<< "$num1 * $num2")

if [ "$(bc <<< "$num2 != 0")" -eq 1 ]; then
  division=$(bc <<< "$num1 / $num2")
else
  division="Error: Division by zero is not allowed."
fi

# Display the results
echo "Sum: $sum"
echo "Difference: $difference"
echo "Product: $product"
echo "Division: $division"
