# -*- coding: utf-8 -*-
"""
Created on Fri Jan 31 22:51:18 2020

@author: lorenzo
"""

# A magic command to enable matplotlib figures in notebook!!!

# import
# A magic command to enable matplotlib figures in notebook!!!

# import
import matplotlib.pyplot as plt
import numpy as np 
import pandas as pd
import numpy as np
from scipy.stats import zscore

data = pd.read_csv('data/mc1-reports-data.csv')
data.count()
new_Data = data.set_index(["time","location"]).count(level="location")
num_Of_Hits = new_Data.max(axis=1)

fig = plt.figure()  # an empty figure 

plt.figure(figsize=(5,5), dpi=500)

plt.axis([0, 6, 0, 20000])
plt.xlabel('Location')
plt.ylabel('Number of Reports')

plt.title("Number of Hits/Location")
num_Of_Hits.plot(kind='bar',color='c', alpha = 0.5)