import React, { useEffect, useState } from 'react';
import { fetchData } from '../Services/apiService';

const MyComponent = () => {
    const [data, setData] = useState('');

    useEffect(() => {
        const getData = async () => {
            try {
                const result = await fetchData();
                setData(result);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        getData();
    }, []);

    return <div>{data}</div>;
};

export default MyComponent;
