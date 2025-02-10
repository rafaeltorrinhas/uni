# jmr 2024 o programa

import sys

# Add auxiliary functions here.
...


def load_lifetimes_file(file_name):
    """Load birth, death, name data from a file."""
    lst = []
    with open(file_name, 'r') as file:
        for line in file:
            # Strip spaces and newline from line
            line = line.strip()
            # Ignore empty lines and comments
            if line == "" or line[:1] == "#":
                continue  # skip to next line
            # Change this to split the line, parse dates
            # and store (date1, date2, name) tuple.
            ...
            lst.append(line)
    return lst


def main():
    file_name = 'composers.txt'  # Replace with your file name
    lifes = load_lifetimes_file(file_name)

    print("THE DEAD COMPOSERS SOCIETY")
    print("==========================")

    for info in lifes:
        # Change this to show Name, Age and Date-of-death in aligned columns.
        ...
        print(info)


if __name__ == "__main__":
    main()

