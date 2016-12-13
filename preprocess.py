import csv
import re
from functools import reduce
from multiprocessing import Pool

# Open a filename for reading and execute the callback with the reader
# iterator.
def withcsv(filename, func):
    with open(filename) as csvfile:
        reader = csv.DictReader(csvfile)
        return func(reader)


# Given a filename and a iterator data, write out each row to the csv file.
def outcsv(filename, data):
    with open(filename, 'w') as outfile:
        writer = csv.writer(outfile)
        for row in data:
            writer.writerow(row)

def process(data, func):
    with Pool(10) as p:
        return p.map(func, data)

# Returns a processed row
def preprocess(row):
    return [
        titleScore(row),
        numFreeDownload(row),
        numWatchMovie(row),
        alphaRatio(row)
    ]


# Count return 0 or 1 depending on whether or not the row has a title.
def titleScore(row):
    return 0 if row['title'] else 1

# Return the number of times a text has "free" or "download".
def numFreeDownload(row):
    return len(re.findall("free|download", row['text'],re.IGNORECASE))

# Return the number of times a text has "movie" or "watch".
def numWatchMovie(row):
    return len(re.findall("movie|watch", row['text'], re.IGNORECASE))

# Return the ratio of alpha characters to total characters * 20.
def alphaRatio(row):
    numAlpha = reduce(isalpha, row['text'], 0)
    multiplier = 20

    return (numAlpha / len(row['text'])) * multiplier

# This is used for the reduce() in alphaRatio.
def isalpha(total, c):
    return total + 1 if c.isalpha() else total
