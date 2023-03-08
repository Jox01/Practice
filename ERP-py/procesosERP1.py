class procesosERP1:

    def __init__(self):
        pass


def menu():
    print("------------------------")
    print("Eligeix la opcio a ejecutar: ")
    print("0 - Sortir del programa")
    print("1 - Mostrar llista de usuaris")
    print("2 - Insertar un nou usuari")
    print("3 - Eliminar un usuari concret")
    print("4 - Consultar stock")
    print("5 - Aumentar stock")
    print("6 - Veure preu del stock")
    print("7 - Aumentar ingresos")
    print("8 - Vendre producte")
    print("9 - Veure costos")
    print("10 - Produir stock")
    print("11 - Mostrar benefici")
    print("12 - Llistar clients")
    print("13 - Client que més ha facturat")
    print("14 - Fer encarrec")
    print("------------------------")
    pass


# llegirUsuaris: 26 insertarNouUsuari: 38
# comprobarUsuario: 55 eliminarUsuari: 66
# llegirStock: 82 aumentarStock: 96
# llegirPreu: 121 afegirIngresos: 134
# vendre: 151 veureCostos: 180
# afegirCostos: 191 produirStock: 207
# mostrarBenefici: 237 comprovarClient: 255


def llegirUsuaris(arxUsuaris):
    fU = open(arxUsuaris, "r")
    linesU = fU.readlines()
    for lines in linesU:
        if lines.startswith("usuario:"):
            print(lines)
        pass
    pass
    fU.close()
    pass


def insertarNouUsuari(arxUsuaris):
    fU = open(arxUsuaris, "r")
    print("Insereix nom del nou usuari")
    nouUsuari = input()
    nouUsuari = "usuario: " + nouUsuari + "\n"

    if comprobarUsuario(nouUsuari, fU):
        print("afegeix contrasenya")
        contrasenyaNova = input()
        contrasenyaNova = "contrasena: " + contrasenyaNova + "\n"
        fU = open(arxUsuaris, "a")
        fU.write("\n" + nouUsuari + contrasenyaNova)
    else:
        print("L'usuari ja existeix")
        pass


def comprobarUsuario(nouUsuari, fU):
    flagU = True
    linesU = fU.readlines()
    for lines in linesU:
        if str(lines) == "usuario: " + nouUsuari + "\n":
            flagU = False
            pass
        pass
    return flagU


def eliminarUsuari(arxUsuaris, nomUsuari):
    f = open(arxUsuaris, "r")
    lines = f.readlines()
    f.close()
    count = 0
    aux = -10
    fU = open(arxUsuaris, "w")
    for line in lines:
        count +=1
        if line == "usuario: "+nomUsuari+"\n":
            print("Se ha trobat el usuari a eliminar")
            line = ""
            fU.write(line)
            aux = count
        elif count == aux + 1: # elimina la contrasenya
            line = ""
            fU.write(line)
        else:
            fU.write(line)
    f.close()


def llegirStock(arxStock):
    fU = open(arxStock, "r")
    i = 0
    linesU = fU.readlines()
    for lines in linesU:

        if lines.startswith("cantidad:"):
            print(lines)
            pass
    pass
    fU.close()
    pass


def aumentarStock(arxStock, nomProducte, cantidadStock):
    f = open(arxStock, "r")
    lines = f.readlines()
    f.close()
    count = 0
    aux = 100

    fU = open(arxStock, "w")
    for line in lines:
        count += 1
        if line == nomProducte:  # si troba el producte el valor de la linea es va al aux
            print("Se a trobat el producte")
            aux = count
            fU.write(line)
        elif count == aux + 1:  # stock esta situat a la seguent linea del producte
            stockAct = int(line.rstrip("\n").lstrip("cantidad: "))  # es talla per fer-ho int stock actual
            fU.write("cantidad: " + str(stockAct + cantidadStock) + "\n")  # es fa la suma i escriu al fitxer
            total = stockAct + cantidadStock
            print("total de stock de " + nomProducte + str(total))  # imprimeix resultat
        elif count != aux + 1:
            fU.write(line)
        pass
    f.close()


def llegirPreu(arxStock):
    fU = open(arxStock, "r")
    linesU = fU.readlines()
    for lines in linesU:
        if lines.startswith("producto:"):
            print(lines)  # llegeix els productes

        if lines.startswith("precio:"):  # llegeix els preus
            print(lines)
    fU.close()
    pass


def afegirIngresos(arxBalance, valorAfegir):
    f = open(arxBalance, "r")
    lines = f.readlines()
    f.close()
    fU = open(arxBalance, "w")
    for line in lines:
        if line.startswith("ingresos: "):
            ingresosAct = int(line.rstrip("\n").lstrip("ingresos: "))  # "tella" string per fer-ho int
            fU.write("ingresos: " + str(ingresosAct + valorAfegir) + "\n")  # esvriu al arx la suma
            print("se ha afegit el valor: " + str(valorAfegir) + " a " + str(ingresosAct))  # pritea resultat
        else:
            fU.write(line)
        pass
    pass
    fU.close()


def vendre(arxStock, arxBalance, arxClients, producte, cantComprar, nomClient):
    aux = 100
    count = 0
    valor = 0

    if comprovarClient(arxClients, nomClient):  # comprova si existeix el client
        crearClient(arxClients, nomClient)  # si no existeix el crea

    f = open(arxStock, "r")
    lines = f.readlines()
    f.close()
    fU = open(arxStock, "w")
    for line in lines:
        count += 1
        if line == str(producte):  # si troba el client el count dona valor al aux
            aux = count
            fU.write(line)
            print(line)
        elif (aux + 2) == count:  # valor aux + 2 es la lina del preu del producte
            valor = int(line.lstrip("precio: "))  # conseguir valor del producte
            fU.write(line)
            print(line)
        else:
            fU.write(line)
        pass

    fU.close()
    valor = valor * cantComprar # multiplica el valor per la cantidad de stock a comprar
    valor = int(valor * comprovarDesconteClient(arxClients, nomClient))  # ens dona el valor del descompte del client
    afegirIngresos(arxBalance, valor) # el total de la compra se ingresa
    afegirFactura(arxClients, nomClient, valor) # el total de la compra se afegeix a la facturacio del client
    print(valor)
    aumentarStock(arxStock, producte, numaNegativo(cantComprar))  # es suma el num del stock comprat pero en negatiu per fer resta
    pass


def veureCostos(arxBalance):
    f = open(arxBalance, "r")
    lines = f.readlines()
    f.close()
    for line in lines:
        if line.startswith("costos: "):  # llegeix els costos
            print(line)
        pass
    pass


def afegirCostos(arxBalance, valorAfegir):
    f = open(arxBalance, "r")
    lines = f.readlines()
    f.close()
    fU = open(arxBalance, "w")
    for line in lines:
        if line.startswith("costos: "):
            costosAct = int(line.rstrip("\n").lstrip("costos: "))  # "tella" string per fer-ho int
            fU.write("costos: " + str(costosAct + valorAfegir) + "\n")  # escriu al arx la suma
            print("se ha afegit el valor: " + str(valorAfegir) + " a " + str(costosAct))  # pritea resultat
        else:
            fU.write(line)
        pass
    pass
    fU.close()
    pass


def produirStock(arxStock, arxBalance, cantidad, producte):
    aux = 100
    count = 0
    valor = 0
    f = open(arxStock, "r")
    lines = f.readlines()
    f.close()
    fU = open(arxStock, "w")
    for line in lines:
        count += 1
        if line == str(producte):  # count pasa al auxiliar
            aux = count
            fU.write(line)
            print(line)
        elif (aux + 2) == count:
            valor = int(line.lstrip("precio: "))  # cull valor del producte
            fU.write(line)
            print(line)
        else:
            fU.write(line)
        pass

    fU.close()

    valor = valor / 3  # els costos son sempre el 33%
    valor = int(valor * cantidad)
    aumentarStock(arxStock, producte, cantidad)
    afegirCostos(arxBalance, valor)
    pass


def mostrarBenefici(arxBalance):  # mostra el benefici
    f = open(arxBalance, "r")
    lines = f.readlines()
    f.close()
    costos = 0
    ingresos = 0
    for line in lines:
        if line.startswith("costos: "):
            costos = int(line.lstrip("costos: "))
        if line.startswith("ingresos: "):
            ingresos = int(line.lstrip("ingresos: ").rstrip("\n"))

    print("Beneficis: " + str(ingresos - costos))
    pass


def numaNegativo(numToNegative):
    numToNegative = int("-" + str(numToNegative))
    return numToNegative


def comprovarClient(arxClients, nom):  # comprova si existeix el client
    f = open(arxClients, "r")
    lines = f.readlines()
    f.close()
    nom = "nom: " + nom + "\n"
    x = True
    for line in lines:
        if line == nom:
            x = False
            print("El client esta registrat")
            pass
    return x


def crearClient(arxClients, nom):  # crea el client
    f = open(arxClients, "a")
    f.write("\n")  # utilitzant el open "a" acaba en el ultimo char, se imprime el \n para el enter
    f.write("nom: " + nom + "\n")
    f.write("facturat: 0\n")
    f.close()
    pass


def comprovarDesconteClient(arxClients, nom):
    f = open(arxClients, "r")
    lines = f.readlines()
    f.close()
    count = 0
    aux = -1
    facturaAct = 0
    descuento = 0
    for line in lines:
        count += 1
        if line == ("nom: " + nom + "\n"):
            aux = count
        elif count == aux + 1:
            facturaAct = int(line.lstrip("facturat: ").rstrip("\n"))

    if facturaAct >= 2000:
        descuento = 0.8
    elif 1000 <= facturaAct < 2000:  # entre 1000 y 2000
        descuento = 0.9
    else:
        descuento = 1

    return descuento


def afegirFactura(arxClients, nom, valor):
    f = open(arxClients, "r")
    lines = f.readlines()
    f.close()
    count = 0
    aux = -1
    facturaAct = 0
    fU = open(arxClients, "w")
    for line in lines:
        count += 1
        if line == ("nom: " + nom + "\n"):
            aux = count
            fU.write(line)
        elif count == aux + 1:
            facturaAct = int(line.lstrip("facturat: ").rstrip("\n"))
            factura = facturaAct + valor
            print("total el client gastat: " + str(factura))
            fU.write("facturat: " + str(factura) + "\n")
        else:
            fU.write(line)
            pass
        pass
    pass


def llegirClients(arxClients):
    f = open(arxClients, "r")
    lines = f.readlines()
    for line in lines:
        print(line)
    pass


def clientMesFacturat(arxClients):
    f = open(arxClients, "r")
    lines = f.readlines()
    auxNom = ""
    auxNomMax = ""
    auxMax = 0
    for line in lines:
        if line.startswith("nom: "):
            auxNom = line
        elif line.startswith("facturat: "):
            auxFact = int(line.lstrip("facturat: ").rstrip("\n"))
            if auxFact > auxMax:
                auxNomMax = auxNom
                auxMax = auxFact
                pass
        pass
    print(auxNomMax)
    print("Valor: " + str(auxMax))
