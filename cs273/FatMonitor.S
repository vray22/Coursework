
#
# Global data (gender, age, and fat)
#
    .data
    .comm gender,1
    .global gender
    .comm age,1
    .global age
    .comm fat,1
    .global fat


#
# Program code (light up function)
#


     .text
     .global lightup
      
lightup:
      ldi r18, 0b00110001
      out 0x04, r18
      lds r21, gender
      lds r22, age 
      lds r23, fat 
      ldi r24, 0x01
      CPI r22, 20
      BRLO brkpoint
      CP  r21, r24
      BREQ male
      CPI r22, 40
      BRSH femaleage2
      CPI r23, 21
           BRSH femaleNor
               jmp lightyellow
femaleNor: CPI r23, 33 
           BRSH femalhigh
           jmp lightgreen  
femalhigh:CPI r23, 39  
            BRSH femalverhigh
            jmp lightred
femalverhigh:jmp alllights
ret
femaleage2:CPI r22, 60
           BRSH femaleage3
           CPI r23, 23
           BRSH fage2nor
           jmp lightyellow
fage2nor:CPI r23, 34
         BRSH fage2high
         jmp lightgreen
fage2high:CPI r23, 40
          BRSH fage2verhigh
          jmp lightred
fage2verhigh:jmp alllights
ret
femaleage3: CPI r22, 80
            BRSH brkpoint
            CPI r23, 24
            BRSH fage3nor
            jmp lightyellow
fage3nor:CPI r23, 36
          BRSH fage3high
          jmp lightgreen
fage3high:CPI r23, 42
          BRSH fage3verhigh
          jmp lightred
fage3verhigh:jmp alllights
ret
lightyellow:
     jmp yellowlight
lightgreen:
     jmp greenlight
lightred:
     jmp redlight
alllights:
     jmp lightsthree
ret     
brkpoint: jmp nothing2         
male: CPI r22, 20
      BRLO brkpoint
      CPI r22, 40
      BRSH mlage2
      CPI r23, 8
      BRSH  malnor
      jmp lightyellow
malnor:CPI r23, 20
       BRSH  malhigh
       jmp lightgreen 
malhigh:CPI r23, 25
        BRSH maverhigh
        jmp lightred
maverhigh:jmp alllights
ret 
mlage2:CPI r22, 60  
       BRSH   mlage3
       CPI  r23, 11
       BRSH  mlage2nor
       jmp lightyellow
mlage2nor:CPI r23, 22
          BRSH maleage2high
           jmp lightgreen      
maleage2high:CPI r23, 28 
        BRSH maleage2veryhigh
        jmp lightred
maleage2veryhigh:jmp alllights
ret
mlage3:CPI r22, 80
       BRSH brkpoint
       CPI  r23, 13
       BRSH  maleage3nor
       jmp lightyellow
maleage3nor:CPI  r23, 25
       BRSH  maleage3high
       jmp lightgreen
maleage3high:CPI  r23, 30
       BRSH maleage3veryhigh
       jmp lightred
maleage3veryhigh:jmp alllights
ret
yellowlight:
                    ldi    r16, 50
all2:  ldi    r17, 0x20
      out    0x05, r17
      ldi    r18, 0xff
dl12:  ldi    r19, 0xff
dl22:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl22
      dec    r18
      brne   dl12
      ldi    r17, 0x00
      out    0x05, r17
      ldi    r18, 0xff
dl32:  ldi    r19, 0xff
dl42:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl42
      dec    r18
      brne   dl32
      dec    r16
      brne   all2
      ret
greenlight:
           ldi    r16, 50
all:  ldi    r17, 0b00010000
      out    0x05, r17
      ldi    r18, 0xff
dl1:  ldi    r19, 0xff
dl2:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl2
      dec    r18
      brne   dl1
      ldi    r17, 0x00
      out    0x05, r17
      ldi    r18, 0xff
dl3:  ldi    r19, 0xff
dl4:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl4
      dec    r18
      brne   dl3
      dec    r16
      brne   all
      ret
    
redlight:
                    ldi    r16, 50
all1:  ldi    r17, 0b00000001
      out    0x05, r17
      ldi    r18, 0xff
dl11:  ldi    r19, 0xff
dl21:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl21
      dec    r18
      brne   dl11
      ldi    r17, 0x00
      out    0x05, r17
      ldi    r18, 0xff
dl31:  ldi    r19, 0xff
dl41:  nop
      nop
      nop
      nop
      dec    r19
      brne   dl41
      dec    r18
      brne   dl31
      dec    r16
      brne   all1
      ret
lightsthree:
           ldi r18, 0b00110001
           out 0x05, r18
      
ret 
nothing2: ret 

      

      
