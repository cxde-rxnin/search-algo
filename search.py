def linear_search(arr, target):
    """
    Perform linear search on an array to find a target element.
    
    Args:
        arr (list): The input array to search through
        target: The element to find
        
    Returns:
        int: Index of the target if found, -1 otherwise
        list: List of all occurrences if multiple exist
    """
    if not arr:
        return -1, []
    
    occurrences = []
    for i, element in enumerate(arr):
        if element == target:
            occurrences.append(i)
    
    return occurrences[0] if occurrences else -1, occurrences

def get_valid_integer_input(prompt):
    """Get and validate integer input from user."""
    while True:
        try:
            value = input(prompt)
            result = int(value)
            if 'size' in prompt.lower() and result <= 0:
                print("Please enter a positive number.")
                continue
            return result
        except ValueError:
            print("Invalid input. Please enter a valid integer.")

def get_array_input(size):
    """Get and validate array input from user."""
    while True:
        try:
            print(f"\nEnter {size} space-separated integers:")
            values = input().strip().split()
            
            if len(values) != size:
                print(f"Error: Please enter exactly {size} numbers.")
                continue
                
            return [int(x) for x in values]
        except ValueError:
            print("Error: Please enter valid integers separated by spaces.")

def main():
    try:
        # Get array size
        size = get_valid_integer_input("Enter the number of elements in the array: ")
        
        # Get array elements
        arr = get_array_input(size)
        
        # Get search target
        target = get_valid_integer_input("Enter the element to search: ")
        
        # Perform search
        first_occurrence, all_occurrences = linear_search(arr, target)
        
        # Display results
        if first_occurrence != -1:
            print(f"\nElement {target} found at index: {first_occurrence}")
            print(f"Position in array: {first_occurrence + 1}")
            
            # If multiple occurrences exist
            if len(all_occurrences) > 1:
                print("\nAll occurrences found at indices:", all_occurrences)
                print("Positions in array:", [pos + 1 for pos in all_occurrences])
        else:
            print(f"\nElement {target} not found in the array.")
            
        # Display the array for reference
        print("\nCurrent array:", arr)
        
    except KeyboardInterrupt:
        print("\nProgram terminated by user.")
    except Exception as e:
        print(f"\nAn unexpected error occurred: {str(e)}")

if __name__ == "__main__":
    main()