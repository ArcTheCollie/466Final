from preprocess import withcsv, outcsv, process, preprocess

def ham(row):
    result = preprocess(row)
    # The last column should be 0 for not spam
    result.append(0)
    return result

outcsv('preprocessed_ham.csv', withcsv('ham.csv', lambda reader: process(reader, ham)))
