import urllib.request
import re
result = urllib.request.urlopen("http://poj.org/problem?id=1001")
content = result.read()
content=content.decode('utf-8')
#print(content.decode("gbk"))
pattern = re.compile('<div class="ptx".*?>(.*?)</div>',re.S)
items = re.findall(pattern, content)
for item in items:
	print(item)