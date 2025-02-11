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

# Show Films with more votes. (groupby + sorted)
numberRatings = mergeRatings.copy()
numberRatings = numberRatings.groupby('title').size().sort_values(ascending=False)
"print('Films with more votes\n%s' % numberRatings[:10])"


myAvg = mergeRatings.copy()
myAvg = myAvg.groupby(['movie_id', 'title'])['rating'].agg(SUM=np.sum, COUNT=np.size, AVG=np.mean)
print('My info ratings : \n%s' % myAvg[:10])
numberRatings.to_csv('D:/Users/pedro.rambar/Desktop/Curso24_25/Servicios y Procesos/python/ml-1m/MyUsers.txt', sep=';')