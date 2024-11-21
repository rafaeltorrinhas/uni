
import requests
import os
import csv
import subprocess

scriptDir = os.path.dirname(os.path.realpath(__file__))        # Obtém o diretório do ficheiro main.py
file_path = os.path.join(scriptDir, 'categories.txt')          # Guarda o caminho do ficheiro categories.txt
file2_path = os.path.join(scriptDir, 'data.csv')               # Guarda o caminho do ficheiro data.csv
fileName = f"{file_path}"
file2Name = f"{file2_path}"

def getPOIs():
    try:
        with open(fileName, 'r') as file:                       # Abre o arquivo em modo de leitura
            lines = file.readlines()                            # Lê as linhas do arquivo
            categories = [line.strip() for line in lines]       # Remove espaços em branco e caracteres de quebra de linha
            return categories                                   # Retorna a lista de categorias
    except FileNotFoundError:
        print(f"O arquivo {fileName} não foi encontrado.")
        return []
    except Exception as e:
        print(f"Ocorreu um erro: {e}")
        return []


def getInfo():
    while True:
        print("Escolha a opção de localização:")                                    # Pergunta ao utilizador se quer escolher a localização ou usar uma predefinida
        print("1. Localização específica")
        print("2. Localização predefinida (centro dos distritos portugueses)")

        locationChoice = input("Escolha uma opção: ")

        if locationChoice == '1':
            clearTerminal()
            coordinates = input("Coloque a sua latitude e longitude separadas por uma vírgula (LAT,LON): \n")           # Pede ao utilizador para inserir as coordenadas se escolher a opção 1
            latitude, longitude = map(str.strip, coordinates.split(','))
            
            break
        elif locationChoice == '2':
            ptDistricts = {
                1: ('40.6401', '-8.6537'),  # Aveiro
                2: ('38.0142', '-7.8632'),  # Beja
                3: ('41.5333', '-8.4167'),  # Braga
                4: ('41.8057', '-6.7571'),  # Bragança
                5: ('39.8238', '-7.4906'),  # Castelo Branco
                6: ('40.2056', '-8.4196'),  # Coimbra
                7: ('38.5731', '-7.9025'),  # Évora
                8: ('37.0194', '-7.9322'),  # Faro
                9: ('40.5364', '-7.2674'),  # Guarda                                        # Coordenadas dos centros dos distritos portugueses
                10: ('39.7436', '-8.8076'),  # Leiria
                11: ('38.7167', '-9.1333'),  # Lisboa
                12: ('39.2945', '-7.4285'),  # Portalegre
                13: ('41.1496', '-8.6109'),  # Porto
                14: ('39.2369', '-8.6850'),  # Santarém
                15: ('38.5224', '-8.8962'),  # Setúbal
                16: ('41.6935', '-8.8309'),  # Viana do Castelo
                17: ('41.3000', '-7.7333'),  # Vila Real
                18: ('40.6566', '-7.9125'),  # Viseu
            }
            clearTerminal()
            print("Escolha um centro de distrito por entre um destes:")
            print("[1] Aveiro")
            print("[2] Beja")
            print("[3] Braga")
            print("[4] Bragança")
            print("[5] Castelo Branco")
            print("[6] Coimbra")
            print("[7] Évora")
            print("[8] Faro")
            print("[9] Guarda")
            print("[10] Leiria")                        # Mostra ao utilizador os distritos disponíveis
            print("[11] Lisboa")
            print("[12] Portalegre")
            print("[13] Porto")
            print("[14] Santarém")
            print("[15] Setúbal")
            print("[16] Viana do Castelo")
            print("[17] Vila Real")
            print("[18] Viseu")

            chosenDistrict = int(input("Digite o número do distrito: "))                    # Pede ao utilizador para escolher um distrito
            if chosenDistrict not in ptDistricts:
                clearTerminal()
                print("Opção inválida. Tente novamente.")  # Se o utilizador não escolher uma opção válida, mostra uma mensagem de erro e volta a pedir para escolher uma opção
            else:                                        
                latitude, longitude = ptDistricts.get(chosenDistrict, ('', ''))
            break
        else:
            clearTerminal()
            print("Opção inválida. Tenta outra vez.")                      # Se o utilizador não escolher uma opção válida, mostra uma mensagem de erro e volta a pedir para escolher uma opção
            continue
    clearTerminal()
    while True:
        
        distance = input("Quão longe quer viajar (km)? \n")
        if distance.isdigit():
            clearTerminal()
            break
        else:
            clearTerminal()
            print("Localização inválida (Tem que ser um número inteiro). Tente novamente.")

    while True:
        poiTypes = input("Que tipo de Pontos de Interesse quer visitar? \n"
                         "1. Escolhe a categoria de Pontos de Interesse\n"
                         "2. Ver categorias (Abre um ficheiro com informações)\n"
                         "Escolha uma opção:\n")

        if poiTypes == '1':
                clearTerminal()
                poiTypesInput = input("Digite os tipos de Pontos de Interesse (Separe por vírgula caso seja mais que 1):\n")
                categories = [category.strip() for category in poiTypesInput.split(',')]
                break
        elif poiTypes == '2':
                clearTerminal()
                try:
                    subprocess.Popen(['notepad.exe', fileName], shell=True)  # Open file in Notepad (Windows example)
                    poiTypesInput = input("Digite os tipos de Pontos de Interesse (Separe por vírgula caso seja mais que 1):\n")
                    categories = [category.strip() for category in poiTypesInput.split(',')]
                    break
                except FileNotFoundError:
                    print(f"O arquivo {fileName} não foi encontrado.")
                    break
                except Exception as e:
                    print(f"Ocorreu um erro: {e}")
                    break
        else:
            clearTerminal()
            print("Opção inválida. Tente novamente.")
    while True:
        clearTerminal()
        limitInput = input("Quantos Pontos de Interesse quer ver? \n")
        if limitInput.isdigit():
            clearTerminal()
            break
        else:
            clearTerminal()
            print("Localização inválida (Tem que ser um número inteiro). Tente novamente.")

    return latitude, longitude, distance, categories, limitInput
    

def getNearPOIs(api_key, latitude, longitude, distance, categories, limitInput):
    clearTerminal()
    print("A procurar Pontos de Interesse...")
    url = "https://api.geoapify.com/v2/places"
    all_POIs = []
    for category in categories:
        param = {
            "categories": category,
            "lat": latitude,
            "lon": longitude,
            "radius": distance,
            "apiKey": api_key,
            "limit": limitInput,
        }

        req = requests.get(url, params=param)
        if req.status_code == 200:
            json_data = req.json()
            POIs = json_data.get('features', [])
            all_POIs.extend(POIs)
        else:
            print(f"Erro na requisição: {req.status_code}")
            return None
    return all_POIs

def processPOIs(POIsList):
    if POIsList:
        print("\nPontos de Interesse exportados para o ficheiro CSV:")
        for POI in POIsList:
            name = POI.get('properties', {}).get('name', 'Nome não disponível')
            country = POI.get('properties', {}).get('country', 'País não disponível')
            loc = POI.get('geometry', {}).get('coordinates', 'Localização não disponível')
            distance = POI.get('properties', {}).get('distance', 'Distância não disponível')
            address = POI.get('properties', {}).get('formatted', 'Morada não disponível')
            city = POI.get('properties', {}).get('city', 'Cidade não disponível')
            categories = POI.get('properties', {}).get('categories', 'Categorias não disponíveis')
            
            print(f"Nome do Ponto de Interesse: {name}")
            print(f"País: {country}")
            print(f"Cidade: {city}")
            print(f"Localização: {loc}")
            print(f"Distância à Localização de Partida: {distance} m")
            print(f"Morada Completa: {address}")
            print(f"Categorias: {categories}")
            print("\n")
    else:
        print("Não foi possível obter informações sobre os Pontos de Interesse.")



def main_menu():        # Mostra as informações iniciais e pergunta ao utilizador se quer começar
    print("Bem-vindo ao programa!")
    print("Informações acerca do programa:\n")
    print("Este programa mostra ao utilizador os Pontos de Interesse que estão disponíveis num raio definido pelo utilizador (ex: 10km mostra todos os Pontos de Interesse num raio de 10km)")
    print("O utilizador terá que escolher a categoria que deseja proucurar através da lista posteriormente fornecida.")
    print("O ponto de partida é definido no formato: latitude,longitude\n")
    choice = input("Deseja começar? (s/n):\n")
    return choice

def main():
   while True:
        
        choice = main_menu()

        if choice == "n":
           print("Obrigado por jogares!")       # Sai do programa se o utilizador não quiser começar
           break
        elif choice == "s":
           clearTerminal()
           latitude, longitude, distance, categories, limitInput = getInfo()        # Chama a função para obter as informações
           api_key = 'd2b073806d1d4dfcb00db87b038fdfb6'                # Chave da API
           POIsList = getNearPOIs(api_key, latitude, longitude, distance, categories, limitInput)   # Chama a função para obter os Pontos de Interesse

           if POIsList:
                print(f"\nTotal de pontos de interesse exportados para CSV: {len(POIsList)}\n")

                processPOIs(POIsList)       # Chama a função para processar os Pontos de Interesse 
                exportCsv(POIsList)         # Exporta as categorias para o ficheiro CSV
               
                medDistance = sum(POI.get('properties', {}).get('distance', 0) for POI in POIsList) / len(POIsList)         # Calcula a distância média
                medDistanceKm = medDistance / 1000                          # Transforma a distância média em Km
                print(f"\nDistância média: {medDistanceKm:.2f} km\n")   

                while True:
                    repeat = input("Deseja recomeçar? (s/n): ")     # Pergunta ao utilizador se quer repetir
                    if repeat.lower() == 's':           
                        clearTerminal() 
                        main()                                     # Chama a função main() se o utilizador quiser repetir
                    elif repeat.lower() == 'n':
                        print("Obrigado por jogares!")              
                        exit()                                       # Sai do programa se o utilizador não quiser repetir
                    else:
                        clearTerminal()
                        print("Opção inválida!")                    
        else:
           clearTerminal()
           print("Opção inválida. Por favor, escolha uma opção válida.")
           

def exportCsv(POIsList):
    with open(file2Name, 'w', newline='', encoding='utf-8') as file2:
        writer = csv.writer(file2)
        writer.writerow(['NOME', 'PAÍS', 'CIDADE', 'ESTADO', 'RUA', 'Nº', 'LATITUDE', 'LONGITUDE', 'DISTÂNCIA', 'CATEGORIAS', 'ID'])
        for POI in POIsList:
            name = POI.get('properties', {}).get('name', '')
            country = POI.get('properties', {}).get('country', '')
            city = POI.get('properties', {}).get('city', '')
            state = POI.get('properties', {}).get('state', '')
            street = POI.get('properties', {}).get('street', '')
            housenumber = POI.get('properties', {}).get('housenumber', '')
            latitude = POI.get('geometry', {}).get('coordinates', [])[1]
            longitude = POI.get('geometry', {}).get('coordinates', [])[0]
            distance = POI.get('properties', {}).get('distance', 0)
            placeId = POI.get('properties', {}).get('place_id', '')
            categories = POI.get('properties', {}).get('categories', '')
            writer.writerow([name, country, city, state, street, housenumber, latitude, longitude, distance, categories, placeId])
    file2.close()
    os.startfile(file2Name)     
                                                    # Abre o ficheiro data.csv
def clearTerminal():                                    # Limpa o terminal
     os.system('cls' if os.name == 'nt' else 'clear')

if __name__ == "__main__":
    main()
   