
length = 6 #starting length
input = ""
count = 0
collection = ["a","b","c","d"]
numbers =  Array.new(length) { |i| i=1 }
size = collection.count
t = size**length
def add (count,size,ind)
	count[ind] += 1
	if count[ind] > size
		if (count[ind+1] != nil)
			count[ind] = 1
			add count,size,(ind+1)
		else
			count[ind] -=1
		end
	end
end

def eval count, collection
	str = ""
	count.each { |e| str << collection[e-1] }
	return str
end

puts "size #{t}"
sendbuffer = ""
t.times { |n| 
	add numbers, size, 0
	puts eval numbers, collection
 }


puts numbers.join(",")
