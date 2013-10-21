open FILE,"core.clj";
my $str;
while (<FILE>) {
	$str .= $_;
}
$str =~ s/\s+|;.*\s/\(comment\)/gm;
close FILE;
open FILE2,">>", "log.txt";
	print FILE2 $str;
close FILE2;