import subprocess

output1 = subprocess.check_output("java island_with_graph", stderr=subprocess.PIPE)
output2 = subprocess.check_output("java island_without_graph", stderr=subprocess.PIPE)

print(output1, output2)