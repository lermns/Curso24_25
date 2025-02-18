# -*- coding: utf-8 -*-
"""
Created on Tue Feb  4 14:22:36 2025

@author: pedro.rambar

Pandas
"""
import pandas as pd
import numpy as np

# Load Data
userHeader = ['user_id', 'gender', 'age', 'ocupation', 'zip']
users = pd.read_table('D:/Users/pedro.rambar/Desktop/Curso24_25/Servicios y Procesos/python/ml-1m/users.dat', engine='python', sep='::', header=None, names=userHeader)

movieHeader = ['movie_id', 'title', 'genders']
movies = pd.read_table('D:/Users/pedro.rambar/Desktop/Curso24_25/Servicios y Procesos/python/ml-1m/movies.dat', engine='python', sep='::', header=None, names=movieHeader, encoding='latin-1')

ratingHeader = ['user_id', 'movie_id', 'rating', 'timestamp']
ratings = pd.read_table('D:/Users/pedro.rambar/Desktop/Curso24_25/Servicios y Procesos/python/ml-1m/ratings.dat', engine='python', sep='::', header=None, names=ratingHeader)

# Merge data
mergeRatings = pd.merge(pd.merge(users, ratings), movies)
"""
# Show Films with more votes. (groupby + sorted)
numberRatings = mergeRatings.copy()
numberRatings = numberRatings.groupby('title').size().sort_values(ascending=False)
"print('Films with more votes\n%s' % numberRatings[:10])"


myAvg = mergeRatings.copy()
myAvg = myAvg.groupby(['movie_id', 'title'])['rating'].agg(SUM=np.sum, COUNT=np.size, AVG=np.mean)
print('My info ratings : \n%s' % myAvg[:10])
numberRatings.to_csv('D:/Users/pedro.rambar/Desktop/Curso24_25/Servicios y Procesos/python/ml-1m/MyUsers.txt', sep=';')

df_1 = mergeRatings.copy()
df_2 = df_1.pivot_table(index=['movie_id', 'title'], values=['rating', 'age'])
print ('Columns(movie_id + title) to Index and avg by values \n%s' % df_2[:5])
"""
df_3 = mergeRatings.copy()
df_3 = df_3.pivot_table(index=['movie_id', 'title'], values=['rating'], aggfunc=[np.sum, np.size, np.mean])
print ('Columns(movie_id + title) to Index and specific functios by values \n%s' % df_3[:5])

# valores del 1992 que tengan una media de mas de 4 en rating