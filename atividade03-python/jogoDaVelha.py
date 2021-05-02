# Jogo da velha utilizando threds :)
"""
Grupo:
Eduardo Akira Hanada Oushiro - 1903669
Matheus Pollini Malaquias - 1903942
William Alves Ribeiro - 1903690
"""
from threading import *
import random
import time

print("""
Bem vindo ao jogo da velha utilizando threds
""")

# Tabela -
table = [['-', '-', '-'],
         ['-', '-', '-'],
         ['-', '-', '-']]

# Variaveis para o semaforo:
control = random.randint(1, 2)
jogadas = 0

# Máquina 1
def jogada_x(nome, space='X', max=9):
    global table, control, jogadas

    while jogadas < max:
        while control != 1:
            pass
        vencedor()
        print(f'{nome}')
        i = random.randrange(0, 3)
        j = random.randrange(0, 3)
        while table[i][j] != '-':
            i = random.randrange(0, 3)
            j = random.randrange(0, 3)
        if table[i][j] == '-':
            table[i][j] = space
            print(table[0][0] + "|" + table[0][1] + "|" + table[0][2])
            print(table[1][0] + "|" + table[1][1] + "|" + table[1][2])
            print(table[2][0] + "|" + table[2][1] + "|" + table[2][2])
            time.sleep(0.495)
        print("-----------")
        control = 2
        jogadas += 1
    control = 0

# Máquina 2
def jogada_o(nome, space, max=9):
    global table, control, jogadas

    while jogadas < max:
        while control != 2:
            pass
        vencedor()
        print(f'{nome}')
        i = random.randrange(0, 3)
        j = random.randrange(0, 3)
        while table[i][j] != '-':
            i = random.randrange(0, 3)
            j = random.randrange(0, 3)
        if table[i][j] == '-':
            table[i][j] = space
            print(table[0][0] + "|" + table[0][1] + "|" + table[0][2])
            print(table[1][0] + "|" + table[1][1] + "|" + table[1][2])
            print(table[2][0] + "|" + table[2][1] + "|" + table[2][2])
            time.sleep(0.495)
        print("-----------")
        control = 1
        jogadas += 1
    control = 0


# Define o vencedor
def vencedor():
    if (table[0][0] == 'X' and table[0][1] == 'X' and table[0][2] == 'X' or
            table[1][0] == 'X' and table[1][1] == 'X' and table[1][2] == 'X' or
            table[2][0] == 'X' and table[2][1] == 'X' and table[2][2] == 'X' or
            # vertical
            table[0][0] == 'X' and table[1][0] == 'X' and table[2][0] == 'X' or
            table[0][1] == 'X' and table[1][1] == 'X' and table[2][1] == 'X' or
            table[0][2] == 'X' and table[1][2] == 'X' and table[2][2] == 'X' or
            # diagonal
            table[0][0] == 'X' and table[1][1] == 'X' and table[2][2] == 'X' or
            table[0][2] == 'X' and table[1][1] == 'X' and table[2][0] == 'X'):
        print('Máquina_1 (X) ganhou!')
        print('----------------------')

    elif (table[0][0] == 'O' and table[0][1] == 'O' and table[0][2] == 'O' or
          table[1][0] == 'O' and table[1][1] == 'O' and table[1][2] == 'O' or
          table[2][0] == 'O' and table[2][1] == 'O' and table[2][2] == 'O' or
          # vertical
          table[0][0] == 'O' and table[1][0] == 'O' and table[2][0] == 'O' or
          table[0][1] == 'O' and table[1][1] == 'O' and table[2][1] == 'O' or
          table[0][2] == 'O' and table[1][2] == 'O' and table[2][2] == 'O' or
          # diagonal
          table[0][0] == 'O' and table[1][1] == 'O' and table[2][2] == 'O' or
          table[0][2] == 'O' and table[1][1] == 'O' and table[2][0] == 'O'):
        print('Máquina_2 (O) ganhou!')
        print('----------------------')

    elif table == 9:
        print('Empataram')
        print('----------------------')


# Declara as Threads
maquina_um = Thread(target=jogada_x, args=('Máquina - 1 jogando!', 'X'))
maquina_dois = Thread(target=jogada_o, args=('Máquina - 2 jogando!', 'O'))

# Inicia as Threads
maquina_um.start()
maquina_dois.start()
