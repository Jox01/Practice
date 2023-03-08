import procesosERP1

print("Benvingut al ERP de Almodonis")

arxUsuaris = "usuaris.txt"

arxStock = "stock.txt"

arxBalance = "balance.txt"

arxClient = "clients.txt"

bucleBoolean = True

p = procesosERP1


while bucleBoolean == True:

    procesosERP1.menu()

    slc = int(input())

    if slc == 0:
        bucleBoolean = False
    elif slc == 1:
        p.llegirUsuaris(arxUsuaris)
    elif slc == 2:
        p.insertarNouUsuari(arxUsuaris)
    elif slc == 3:
        print("Inserti nom usuari")
        user = input()
        print("Inserti contresenya")
        passw = input()
        if(user == "admin" and passw == "1234"):
            print("Quin usuari elimina?")
            nomUsuari = input()
            p.eliminarUsuari(arxUsuaris, nomUsuari)
        else:
            print("No te permisos suficients")
    elif slc == 4:
        p.llegirStock(arxStock)
    elif slc == 5:
        print("Quin producte vol aumentar?")
        nomProducte = input()
        nomProducte = "producto: " + nomProducte + "\n"
        print("Quina cantidad vol aumentar?")
        cantidadStock = int(input())
        p.aumentarStock(arxStock, nomProducte, cantidadStock)
    elif slc == 6:
        p.llegirPreu(arxStock)
    elif slc == 7:
        print("Quina cantidad  de ingresos vol afegir?")
        ingresosAfegir = int(input())
        p.afegirIngresos(arxBalance, ingresosAfegir)
    elif slc == 8:
        print("Quin producte vol comprar?")
        nomProducte = "producto: " + str(input()) + "\n"
        print("Quina cantidad?")
        cantidad = int(input())
        print("Com es diu el client?")
        nom = input()
        p.vendre(arxStock, arxBalance, arxClient, nomProducte, cantidad, nom)
    elif slc == 9:
        p.veureCostos(arxBalance)
    elif slc == 10:
        print("Quin producte vol produir?")
        nomProducte = "producto: " + str(input()) + "\n"
        print("Quina cantidad?")
        cantidad = int(input())
        p.produirStock(arxStock, arxBalance, cantidad, nomProducte)
    elif slc == 11:
        p.mostrarBenefici(arxBalance)
    elif slc == 12:
        p.llegirClients(arxClient)
    elif slc == 13:
        p.clientMesFacturat(arxClient)
    elif slc == 14:
        seguir = True
        print("Com es diu el client?")
        nom = input()
        while seguir:
            print("Quin producte vol comprar?")
            nomProducte = "producto: " + str(input()) + "\n"
            print("Quina cantidad?")
            cantidad = int(input())
            p.vendre(arxStock, arxBalance, arxClient, nomProducte, cantidad, nom)
            print("Vols seguir la comanda? (s/n)")
            x = input()
            if x != "s":
                seguir = False
                pass
        print("Fi de comanda")
        pass


print("Fi del programa")
