from preprocess import withcsv, outcsv, process, preprocess

def spam(row):
    result = preprocess(row)
    # The last column should be 1 for spam
    result.append(1)
    return result

outcsv('preprocessed_spam.csv', withcsv('spam.csv', lambda reader: process(reader, spam)))
