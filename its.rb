set = ["a","b","c","d"]
size = set.count
counter = Array.new(size) { |i| i = 1 }
def add counter, size, index
	counter[size]+=1
end