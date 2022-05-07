import pexpect
import re
import random

N = random.randint(20, 30);
print("N : ", end='')
print(N)
l = list(range(1, N+1))
print("list : ", end='')
print(l)
random.shuffle(l)
print("shuffled list : ", end='')
print(l)


ans_re = re.compile(r'\? (\d+) (\d+)')
from pexpect import popen_spawn
child = popen_spawn.PopenSpawn('java F_SinkingShip')
child.sendline(b'%d' % N)
print(">>> sended : ", end='')
print(N)

answer = child.readline().decode()

print("<<< got answer :", end='')
print(answer.strip())

while(answer[0] == "?"):
	res = ans_re.search(answer)
	start = int(res[1])
	end = int(res[2])
	m = max(l[start-1:end])
	child.sendline(b'%d' % m)
	print(">>> sended : ", end='')
	print(m)
	
	answer = child.readline().decode()

	print("<<< got answer :", end='')
	print(answer.strip())
	if(answer[0] == "!"):
		break


ans_re2 = re.compile(r'\! (\d+)')
res = ans_re2.search(answer)
print('>>> final answer : ', end='')
print(res[1])

if(int(res[1]) == l.index(N-1)+1):
	print(l.index(N-1)+1)
	print("Answer is correct.")
else:
	print(l.index(N-1)+1)
	print("Wrong answer.")