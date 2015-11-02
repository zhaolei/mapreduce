import sys

if len(sys.argv) < 2:
    print 'Usage: python sql.py datafile'
    exit()

ofile = sys.argv[1]
fp = open(ofile, 'r')

line = fp.readline()

while line:
    ar = line.split(',')
    ar[2] = ar[2].strip()
    print "INSERT INTO  `data`.`mahout_item` (`uid` ,`item` ,`score`) values('%s','%s','%s');"%(ar[0], ar[1], ar[2])
    line = fp.readline()
