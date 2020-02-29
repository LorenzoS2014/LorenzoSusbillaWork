module ram128x16test();
reg[5:0] i;
reg[5:0] adrs;
reg[7:0] content;
reg _ce, _we, _oe;
wire[7:0] dataIn;
wire[7:0] dataOut;
assign dataIn = ~_ce & ~_we & _oe ? content : 8'hz;
ram128x16 u1(adrs, dataIn, dataOut, _ce, _we, _oe);
initial begin

$monitor ("%4d: adrs(deci) = %d adrs(hexi) = %h _ce = %b _we = %b_oe = %b dataIn =%h dataOut= %h", $time, adrs, adrs, _ce, _we, _oe, dataIn, dataOut);
adrs = 6'b000000;
content = 8'hFF;
_ce = 0; _we = 0; _oe = 1;
#10
_ce = 1; _we = 1; _oe = 1;
#50
adrs = 6'b010000;
content = 8'hEE;
_ce = 0; _we = 0; _oe = 1;
#10
_ce = 1; _we = 1; _oe = 1;
#40
adrs = 6'b100000;
content = 8'hDD;
_ce = 0; _we = 0; _oe = 1;
#10
_ce = 1; _we = 1; _oe = 1;
#40
adrs = 6'b110000;
content = 8'hCC;
_ce = 0; _we = 0; _oe = 1;
#10
_ce = 1; _we = 1; _oe = 1;
#40
adrs = 6'b000000;
_ce = 0; _we = 1; _oe = 0;
#10
_ce = 1; _we = 1; _oe = 1;
#60
adrs = 6'b010000;
_ce = 0; _we = 1; _oe = 0;
#10
_ce = 1; _we = 1; _oe = 1;
#30
adrs = 6'b100000;
_ce = 0; _we = 1; _oe = 0;
#10
_ce = 1; _we = 1; _oe = 1;
#30
adrs = 6'b110000;
_ce = 0; _we = 1; _oe = 0;
#10
_ce = 1; _we = 1; _oe = 1;
#30
$finish;
end
endmodule