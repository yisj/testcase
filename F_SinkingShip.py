import random
import subprocess
from io import BytesIO

N = random.randint(20, 30);
print(N)
l = list(range(1, N+1))
print(l)
random.shuffle(l)
print(l)


cmd = ['java', 'F_SinkingShip']
p = subprocess.Popen(cmd, stdin=subprocess.PIPE, stdout=subprocess.PIPE)
p.stdin.write(b'%d\n' % N)
if p.stdout.closed:
	print(p.stdout)
# print(p.stdout.readline())
# grep_stdout = BytesIO(p.stdout)
# print(grep_stdout)
# data = grep_stdout.split(' ')
# while(data[0] == '?'):
# 	start = int(data[1])
# 	end = int(data[2])
# 	sublist = l[start-1:end]
# 	m = max(sublist)
# 	p.stdin.write(b'%d\n' % m)
# 	grep_stdout = BytesIO(p.stdout)
# 	data = grep_stdout.split(' ')
# 	if(data[0] == '!'):
# 		print(data[1])
# 		print(data[1] == N-1)
# 		break
