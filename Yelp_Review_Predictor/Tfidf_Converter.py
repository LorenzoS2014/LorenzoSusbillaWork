# -*- coding: utf-8 -*-
"""
Created on Thu Feb 20 10:33:45 2020

@author: lorenzo
"""
from collections.abc import Sequence
from sklearn import preprocessing
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import shutil
import os
import csv
import sklearn.feature_extraction.text as sk_text
from sklearn.model_selection import train_test_split
from sklearn import metrics

path = './data/'
filename_write = os.path.join(path,"class_vectorized_review.csv")

data = pd.read_csv("./data/class_example.csv", encoding="utf-8")


vectorizer = sk_text.TfidfVectorizer( stop_words='english',max_features = 1000, min_df=1)

matrix = vectorizer.fit_transform(data['all_reviews']) #turns all reviews into a tf-idf vector
tfidf_data = matrix.toarray().tolist() #vector converterd into a list for data frame
data.drop('all_reviews', axis = 1, inplace= True) 
#data.drop('Unnamed: 0', axis = 1, inplace= True)
#data.drop('Unnamed: 0.1', axis = 1, inplace= True)
data.insert(2, 'all_reviews', tfidf_data) #inserts the tfidf vector into data
text_data = pd.DataFrame(data['all_reviews'].values.tolist(), columns= vectorizer.get_feature_names())
data.drop('all_reviews', axis = 1, inplace= True)
data = pd.concat([data, text_data], axis = 1)
data.to_csv(filename_write,index= False)