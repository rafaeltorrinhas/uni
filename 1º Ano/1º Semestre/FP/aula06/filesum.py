from tkinter import filedialog

def main():
    # 1) Pedir nome do ficheiro (experimente cada alternativa):
    
    #name = input("File? ")                                 #A
    name = filedialog.askopenfilename(title="Choose File") #B
    
    # 2) Calcular soma dos números no ficheiro:
    total = fileSum(name)
    # 3) Mostrar a soma:
    print("Sum:", total)
    
    

def fileSum(name):
    # Complete a função para ler números do ficheiro e devolver a sua soma
    total = 0
    try:
        with open(name, 'r') as file:
            for line in file:
                try:
                    total += float(line)
                except ValueError:
                    print("Passando um número inválido à frente:", line)
    except FileNotFoundError: 
        print("Ficheiro inválido.")
    return total

if __name__ == "__main__":
    main()

