# -*- coding: utf-8 -*-
"""
Editor de Spyder

Este es un archivo temporal.
"""
import functools

def ac (radio):
    return radio*2

def esPar(n):
    if n%2==0 and n!=0:
        return True
    return False
    
lista = list(map(ac, range(1,5)))

print(lista)

listaPar = list(filter(esPar, range(1,11)))

print(listaPar)

listaReduce = [7, 2, -2, 5]

def mult(x,y):
    return x*y

listResReduce = functools.reduce(mult, listaReduce)

print(listResReduce)

aTriangulo = lambda b, h: b*h/2

print(aTriangulo(3,4)) 