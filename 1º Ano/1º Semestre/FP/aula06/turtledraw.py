# Exercise 5 on "How to think like a computer scientist", ch. 11.

import turtle
from tkinter import filedialog
def main():
    screen = turtle.Screen()
    t = turtle.Turtle()

    # Use t.up(), t.down() and t.goto(x, y)
    drawing = filedialog.askopenfilename(title="Choose File")
    # Put your code here
    try:
        with open(drawing,"r") as file:
            for line in file:
                coord = line.split()
                try:
                    if coord[0] == 'UP':
                        t.up()
                    elif coord[0] == 'DOWN':
                        t.down()
                    else:
                        t.goto(float(coord[0]), float(coord[1]))
                except ValueError:
                    ...
    except FileNotFoundError:
        print("Ficheiro inválido.")



    # Wait until window is closed
    screen.mainloop()


if __name__ == "__main__":
    main()

