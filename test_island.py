import random
import subprocess

W = random.randint(5, 5)
H = random.randint(5, 5)

lines = list()
lines.append("%d %d" % (W, H))
for i in range(H):
	line = list()
	for j in range(W):
		line.append(str(random.randint(0, 1)))
	lines.append(" ".join(line))
lines.append("0 0")
with open("sample_input.txt", "w") as f:
	f.write("\n".join(lines))

output1 = subprocess.check_output("java island_with_graph", stderr=subprocess.PIPE)
output2 = subprocess.check_output("java island_without_graph", stderr=subprocess.PIPE)

print(output1, output2)