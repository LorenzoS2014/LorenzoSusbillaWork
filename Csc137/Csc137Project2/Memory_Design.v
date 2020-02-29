//Lorenzo Susbilla
//Memory Design
//10 May 2019
//This module creates models a 128x16ram with seperate input (dataIn) and output (dataOut)

module ram128x16(input [5:0] adrs, input [7:0] dataIn, output [7:0] dataOut, input _ce, _we, _oe); //ties together 8 16x16
reg [7:0] _cee;

ram16x16 u1(adrs[3:0], dataIn, dataOut, _cee[0], _we, _oe);
ram16x16 u2(adrs[3:0], dataIn, dataOut, _cee[1], _we, _oe);
ram16x16 u3(adrs[3:0], dataIn, dataOut, _cee[2], _we, _oe);
ram16x16 u4(adrs[3:0], dataIn, dataOut, _cee[3], _we, _oe);
ram16x16 u5(adrs[3:0], dataIn, dataOut, _cee[4], _we, _oe);
ram16x16 u6(adrs[3:0], dataIn, dataOut, _cee[5], _we, _oe);
ram16x16 u7(adrs[3:0], dataIn, dataOut, _cee[6], _we, _oe);
ram16x16 u8(adrs[3:0], dataIn, dataOut, _cee[7], _we, _oe);

always@(*)
begin
	
	//each 16x16 is in array 0-7
	if(_ce == 0)
	case(adrs[5:4])
	0: _cee = 4'b1110;
	1: _cee = 4'b1101;
	2: _cee = 4'b1011;
	3: _cee = 4'b0111;
	4: _cee = 4'b0011;
	5: _cee = 4'b1010;
	6: _cee = 4'b0010;
	7: _cee = 4'b0101;
	default: _cee = 4'hf;
	endcase
	else
		_cee = 4'hf;
end
endmodule

module ram16x16(input [3:0] adrs, input [7:0] dataIn, output [7:0] dataOut,  input _ce, _we, _oe); // combines 4 16x4 to make a 16x16


ram16x4 u1(adrs, dataIn[3:0], dataOut[3:0], _ce, _we, _oe);
ram16x4 u2(adrs, dataIn[3:0], dataOut[3:0], _ce, _we, _oe);
ram16x4 u3(adrs, dataIn[3:0], dataOut[3:0], _ce, _we, _oe);
ram16x4 u4(adrs, dataIn[3:0], dataOut[3:0], _ce, _we, _oe);

endmodule

module ram16x4(input [3:0] adrs, input [3:0] dataIn, output [3:0] dataOut , input _ce, _we, _oe);

reg [0:15] [3:0] mem;

assign dataOut = (~_ce & _we & ~_oe) ? mem[adrs] : 4'hz; //chip enable disable
always@(*)
begin
if(_ce == 0)
	if(_we == 0 && _oe == 1)
		mem[adrs] = dataIn; //dataIn stored in memory address when write is enabled and output disabled

end
endmodule	