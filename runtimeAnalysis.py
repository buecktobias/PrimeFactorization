#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd


# In[2]:


import matplotlib.pyplot as plt


# In[65]:


df = pd.read_csv("primeFactorization.csv",sep=",")


# In[66]:


df.head()


# In[13]:





# In[73]:


print(df.describe())


# In[154]:


x = df["number"]
y = df["time"]
plt.title("Prime Factorisation Time Analysis")
plt.scatter(df["number"],df["time"],label="",marker="o",s=1)
x2 = numpy.array(x)
X = numpy.array(x)
Y = numpy.array(y)
coefs = numpy.polyfit(X,Y, deg=2)
y2 = numpy.polyval(coefs,x2)
df = df[df["time"] < 5_000]
plt.plot(x2, y2, label="best fit line", linewidth=2,c="r")
plt.ylabel("Time [ms]")
plt.xlabel("Number")
plt.legend()


ls = []
for degree, number in enumerate(reversed(list(coefs))):
    shorter_num = "%e" % number
    ls.append(f"{shorter_num}x^{degree}")
    
text = "f(x) = " + " + ".join(ls)
plt.text(-10,-1000,text,fontsize=12)
plt.savefig("time_analysis.png")


# In[139]:




