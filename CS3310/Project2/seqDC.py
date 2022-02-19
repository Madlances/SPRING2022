from collections import deque
from functools import partial
from tabulate import tabulate

counter = 0
x = "1234"
y = "1515"
data = []

def basicOps():
    global counter
    return counter

# Divide and Conquer
def all_alignments(x, y):
    """Return an iterable of all alignments of two
    sequences.

    x, y -- Sequences.
    """

    def F(x, y):
        """A helper function that recursively builds the
        alignments.

        x, y -- Sequence indices for the original x and y.
        """
        if len(x) == 0 and len(y) == 0:
            yield deque()

        scenarios = []
        if len(x) > 0 and len(y) > 0:
            scenarios.append((x[0], x[1:], y[0], y[1:]))
        if len(x) > 0:
            scenarios.append((x[0], x[1:], None, y))
        if len(y) > 0:
            scenarios.append((None, x, y[0], y[1:]))

        # NOTE: "xh" and "xt" stand for "x-head" and "x-tail",
        # with "head" being the front of the sequence, and
        # "tail" being the rest of the sequence. Similarly for
        # "yh" and "yt".
        for xh, xt, yh, yt in scenarios:
            for alignment in F(xt, yt):
                alignment.appendleft((xh, yh))
                yield alignment

    alignments = F(range(len(x)), range(len(y)))
    return map(list, alignments)

def print_alignment(x, y, alignment):
    print("".join(
        "-" if i is None else x[i] for i, _ in alignment
    ))
    print("".join(
        "-" if j is None else y[j] for _, j in alignment
    ))
    
def alignment_score(x, y, alignment):
    """Score an alignment.

    x, y -- sequences.
    alignment -- an alignment of x and y.
    """
    global counter
    score_gap = 2
    score_same = 0
    score_different = 1

    score = 0
    for i, j in alignment:
        counter += 1
        if (i is None) or (j is None):
            score += score_gap
        elif x[i] == y[j]:
            score += score_same
        elif x[i] != y[j]:
            score += score_different

    return score

def align_bf(x, y):
    """Align two sequences, minimizing the
    alignment score, using brute force.

    x, y -- sequences.
    """
    return min(
        all_alignments(x, y),
        key=partial(alignment_score, x, y),
    )

print("Alignment of Divide and Conquer:")
print_alignment(x, y, align_bf(x, y))
print("Total Cost/Penality For Divide and Conquer: %s" %alignment_score(x, y, alignment=align_bf(x,y)))
print("")
print("Divide and Conquer Table:")
data.append([basicOps()])
print(tabulate(data, headers=["# of times the basic operation"]))