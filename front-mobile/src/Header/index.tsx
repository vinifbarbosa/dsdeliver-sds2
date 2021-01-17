
import React from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';

function Header() {
  return (
    <View style={styles.container}>
         <Image source={require("../assets/logo.png")} />
      <Text style={styles.text}>DS Delivery</Text>
    
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
      backgroundColor:'#DA5C5C',
      height:80,
      paddingTop:50,
      flexDirection:"row",
      justifyContent:"center"
  },
  text: {
      fontWeight:"bold",
      fontSize: 19,
      lineHeight: 25,
      letterSpacing:-0.024,
      color: "#FFF",
      marginLeft:13,
      fontFamily:" OpenSans_700Bold "
  }
});

export default Header;