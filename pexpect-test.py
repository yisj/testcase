import pexpect
from pexpect import popen_spawn
child = popen_spawn.PopenSpawn('java F_SinkingShip')
child.sendline(b'%d' % 22)
answer = child.expect('\r\n', timeout=1)
print(answer)