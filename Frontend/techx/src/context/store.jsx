import { createContext, useEffect, useState } from "react";
import {products} from '../assets/data/data'

export const store=createContext(null)

const StoreProvider = (props) => {
    const [userData,SetUserData]=useState(null)
    const [ItemData,setItemData]=useState(null)

    useEffect(()=>(
      setItemData(products)
    ),[])
    

    


      const contextValue={
        userData,
        ItemData,
        SetUserData
      }

    return(
        <store.Provider value={contextValue}>
            {props.children}
        </store.Provider>
    )
}

export default StoreProvider