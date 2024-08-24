import { getFoodItems } from '../../services/services';
import './FoodMenu.css'
import { useState , useEffect} from "react";
import Food from './Food';


const FoodMenu = () => {

  const [veg, setVeg] = useState([]);
  const [nonveg, setNonveg] = useState([]);
  const [chinese, setChinese] = useState([]);
  const [selectedType, setSelectedType] = useState('');

  const foodMenuItems = ["veg","nonveg","chinese"];

  useEffect(() => {

    const fetchData = async ()=>{
        const vegFood = await getFoodItems("veg").then((res)=>{return res.data});
        setVeg(vegFood);

        const nonvegFood = await getFoodItems("nonveg").then((res)=>{return res.data});
        setNonveg(nonvegFood);

        const chineseFood = await getFoodItems("chinese").then((res)=>{return res.data});
        setChinese(chineseFood);
    }

    fetchData();

  }, [])

  const getFoodItemsToDisplay = () => {
    if (selectedType === "veg") {
      return veg;
    } else if (selectedType === "nonveg") {
      return nonveg;
    } else if (selectedType === "chinese") {
      return chinese;
    }
    return [];
  };

  const handleMenuClick = (type)=>{
        setSelectedType(type);
  }


  return (
    <>
       <div  className="food-menu-container">    

            {foodMenuItems.map((foodMenuType)=>{

            return <div key={foodMenuType} className="food-menu" id={foodMenuType} onClick={() => handleMenuClick(foodMenuType)}>
                        <h3>{foodMenuType}</h3>
                    </div>
            })}
        </div>

        <div className="food-item-container">
            {getFoodItemsToDisplay().map((item) => (
            <Food key={item.id} item={item} />
            ))}
      </div>
    </>
  )
}

export default FoodMenu