# -*- coding: utf-8 -*-
"""
Created on Thu Feb 20 11:02:07 2020

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
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Activation
from tensorflow.keras.callbacks import EarlyStopping
from tensorflow.keras.callbacks import ModelCheckpoint
from tensorflow.keras.models import load_model

def to_xy(df, target):
    result = []
    for x in df.columns:
        if x != target:
            result.append(x)
    # find out the type of the target column.
    target_type = df[target].dtypes
    target_type = target_type[0] if isinstance(target_type, Sequence) else target_type
    # Encode to int for classification, float otherwise. TensorFlow likes 32 bits.
    if target_type in (np.int64, np.int32):
        # Classification
        dummies = pd.get_dummies(df[target])
        return df[result].values.astype(np.float32), dummies.values.astype(np.float32)
    else:
        # Regression
        return df[result].values.astype(np.float32), df[target].values.astype(np.float32)
    
save_path = "./data/models/protected_networks/"
data = pd.read_csv("./data/vectorized_review.csv", encoding="utf-8")
data.drop('business_id',axis = 1, inplace= True)

x,y = to_xy(data,'business_stars')
#x_train, x_test, y_train, y_test = train_test_split (x, y, test_size=0.25, random_state=45)

model = load_model(os.path.join(save_path,"network_relu1.hdf5"))

pred = model.predict(x)
print(pred)
print(y)
