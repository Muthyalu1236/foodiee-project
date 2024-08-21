import React from 'react'

const DummyItems = ({title,desc, rating, price, image}) => {
  return (
    <>
        <div className='container'>
            <h3>{title}</h3>
            <p>{desc}</p>
            <img src={rating+".jpg"} alt="" />
            <img src={image} alt="" />
            <h4>{price}</h4>
        </div>
    </>
  )
}

export default DummyItems