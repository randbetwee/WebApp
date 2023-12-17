from lxml import etree
import requests
from fake_useragent import UserAgent
import pandas as pd
import random
import time
from bs4 import BeautifulSoup
import csv

headers = {
    'User-Agent' : UserAgent().random,
    #'cookie' : "global_cookie=kxyzkfz09n3hnn14le9z39b9g3ol3wgikwn; city=www; city.sig=OGYSb1kOr8YVFH0wBEXukpoi1DeOqwvdseB7aTrJ-zE; __utmz=147393320.1664372701.10.4.utmcsr=mp.csdn.net|utmccn=(referral)|utmcmd=referral|utmcct=/mp_blog/creation/editor; csrfToken=KUlWFFT_pcJiH1yo3qPmzIc_; g_sourcepage=xf_lp^lb_pc'; __utmc=147393320; unique_cookie=U_bystp5cfehunxkbjybklkryt62fl8mfox4z*3; __utma=147393320.97036532.1606372168.1664431058.1664433514.14; __utmt_t0=1; __utmt_t1=1; __utmt_t2=1; __utmt_t3=1; __utmt_t4=1; __utmb=147393320.5.10.1664433514",
    # 设置从何处跳转过来
    'referer': 'https://cmano-db.com/'
}

url = 'https://cmano-db.com/aircraft/China/'# 首页网址URL
refer='https://cmano-db.com/'
#source_html  = requests.get(url=url, headers=headers).text# 请求发送
tmp_html = "Soviet.html"
with open(tmp_html, "r", encoding="utf-8") as f:
    #f.write(source_html)
    #f.seek(0)
    html_handle = f.read()

tree = etree.HTML(html_handle)

Link=[i.strip() for i in tree.xpath("//div[@class='row']/div/table/tbody/tr/td/a/@href")]
name = [i.strip() for i in tree.xpath("//div[@class='row']/div/table/tbody/tr/td/a/text()")]
Type=[]
Crew=[]
min_speed=[]
max_speed=[]
wingspan=[]
height=[]
Length=[]
MaxPayload=[]
EmptyWeight=[]
MaxWeight=[]
Operator=[]
Commissioned=[]
Propulsion=[]
#newname=[]
m=0
for i in range(len(Link)):
    #detail_url=refer+Link[i]
    #source_html  = requests.get(url=detail_url, headers=headers).text
    with open('Soviet_aircraft/_'+str(i)+'.html', "r", encoding="utf-8") as f:
            #f.write(source_html)
            #f.seek(0)
        
            source_html= f.read()
            #newname.append(name[i])
    

    
    m+=1
    
    tree = etree.HTML(source_html)
    
    detail=[j.lstrip() for j in 
            tree.xpath("//div[@class='col-lg-7']/table[1]/tbody/tr/td/text()")]
    modified_detail = [s.split(":")[1] if ":" in s else s for s in detail]
    Type.append(modified_detail[0])
    Crew.append(modified_detail[1])
    min_speed.append(modified_detail[2])
    max_speed.append(modified_detail[3])
    wingspan.append(modified_detail[4])
    height.append(modified_detail[5])
    Length.append(modified_detail[6])
    MaxPayload.append(modified_detail[7])
    EmptyWeight.append(modified_detail[8])
    MaxWeight.append(modified_detail[9])
    Operator.append(modified_detail[10])
    Commissioned.append(modified_detail[11])
    Propulsion.append(modified_detail[12])

dic = {'name':name,'Type':Type,'Crew': Crew, 
           'Min Speed': min_speed,	 'Max Speed':max_speed,
            'Wingspan': wingspan,'Height':height,
            'Length':Length,	'Max Payload': MaxPayload,
            'Empty Weight': EmptyWeight,	'Max Weight':MaxWeight,
            'Operator': Operator,	'Commissioned':Commissioned,
            'Propulsion': Propulsion}
    
df2 = pd.DataFrame(dic)
df2.to_csv('Soviet_aircraft.csv',index=None)

