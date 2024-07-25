export const categories = [
  'Laptop',
  'Handfree',
  'Mouse',
  'Keyboard',
  'Gaming Chair',
  'Monitor',
  'Tablet',
  'Smartphone',
  'Printer',
  'Webcam',
  'Router',
  'External Hard Drive',
  'USB Flash Drive',
  'Speakers',
  'Headphones',
  'Microphone',
  'Smartwatch'
];


export const specialOffer=[
  {
    title: 'Dell XPS 13 - Compact and Powerful',
    brand: 'Dell',
    model: 'XPS 13',
    description: 'The Dell XPS 13 offers a powerful and compact laptop experience, combining high performance with exceptional portability. Ideal for professionals on the go, it features an Intel Core i7 processor, 16GB of RAM, and a 512GB SSD for speedy operations and ample storage.',
    processor: 'Intel Core i7-1185G7',
    ram: '16GB',
    storage: '512GB SSD',
    screenSize: '13.4 inches',
    resolution: '1920x1200',
    price: '$1,299'
  },
  {
    title: 'Apple MacBook Pro 16-inch - High Performance',
    brand: 'Apple',
    model: 'MacBook Pro 16-inch',
    description: 'The Apple MacBook Pro 16-inch is designed for high performance with a large Retina display and the powerful Apple M1 Pro chip. This laptop provides impressive graphics and processing power, making it perfect for creative professionals and power users.',
    processor: 'Apple M1 Pro',
    ram: '16GB',
    storage: '1TB SSD',
    screenSize: '16.2 inches',
    resolution: '3456x2234',
    price: '$2,499'
  }
]

export const products = [
  {
    category: 'Laptop',
    items: [
      {
        title: 'Dell XPS 13 - Compact and Powerful',
        brand: 'Dell',
        model: 'XPS 13',
        description: 'The Dell XPS 13 offers a powerful and compact laptop experience, combining high performance with exceptional portability. Ideal for professionals on the go, it features an Intel Core i7 processor, 16GB of RAM, and a 512GB SSD for speedy operations and ample storage.',
        processor: 'Intel Core i7-1185G7',
        ram: '16GB',
        storage: '512GB SSD',
        screenSize: '13.4 inches',
        resolution: '1920x1200',
        price: '$1,299'
      },
      {
        title: 'Apple MacBook Pro 16-inch - High Performance',
        brand: 'Apple',
        model: 'MacBook Pro 16-inch',
        description: 'The Apple MacBook Pro 16-inch is designed for high performance with a large Retina display and the powerful Apple M1 Pro chip. This laptop provides impressive graphics and processing power, making it perfect for creative professionals and power users.',
        processor: 'Apple M1 Pro',
        ram: '16GB',
        storage: '1TB SSD',
        screenSize: '16.2 inches',
        resolution: '3456x2234',
        price: '$2,499'
      }
      // ... other laptops
    ]
  },
  {
    category: 'Handfree',
    items: [
      {
        title: 'Sony WF-1000XM4 - Top-Notch Noise Cancellation',
        brand: 'Sony',
        model: 'WF-1000XM4',
        description: 'Sony WF-1000XM4 earbuds deliver top-notch noise cancellation and superb sound quality. They offer a comfortable in-ear fit and long battery life, making them an excellent choice for immersive audio experiences and uninterrupted focus.',
        type: 'In-Ear',
        batteryLife: '8 hours',
        noiseCancellation: 'Active',
        price: '$279'
      },
      {
        title: 'Apple AirPods Pro - Seamless Integration',
        brand: 'Apple',
        model: 'AirPods Pro',
        description: 'The Apple AirPods Pro are known for their seamless integration with Apple devices, offering active noise cancellation and a comfortable in-ear design. With good battery life and high-quality audio, they are a popular choice for users within the Apple ecosystem.',
        type: 'In-Ear',
        batteryLife: '4.5 hours',
        noiseCancellation: 'Active',
        price: '$249'
      }
      // ... other handfree
    ]
  },
  {
    category: 'Mouse',
    items: [
      {
        title: 'Logitech MX Master 3 - Productivity Powerhouse',
        brand: 'Logitech',
        model: 'MX Master 3',
        description: 'The Logitech MX Master 3 is a premium wireless mouse designed for productivity. It features advanced ergonomic design, customizable buttons, and high precision, catering to professionals who need reliable and comfortable input devices.',
        type: 'Wireless',
        DPI: '4000',
        buttons: '7',
        price: '$99'
      },
      {
        title: 'Razer DeathAdder V2 - Precision Gaming',
        brand: 'Razer',
        model: 'DeathAdder V2',
        description: 'Razer DeathAdder V2 is a high-precision wired gaming mouse with customizable buttons and a high DPI setting. It is designed for gamers seeking precision and comfort, featuring a classic ergonomic design and rapid response capabilities.',
        type: 'Wired',
        DPI: '16000',
        buttons: '8',
        price: '$79'
      }
      // ... other mice
    ]
  },
  {
    category: 'Keyboard',
    items: [
      {
        title: 'Corsair K95 RGB Platinum - Advanced Gaming',
        brand: 'Corsair',
        model: 'K95 RGB Platinum',
        description: 'Corsair K95 RGB Platinum is a mechanical keyboard with customizable RGB lighting and dedicated macro keys. It is designed for gamers and professionals who need advanced features and superior performance for typing and gaming.',
        type: 'Mechanical',
        switches: 'Cherry MX',
        backlight: 'RGB',
        price: '$199'
      },
      {
        title: 'Logitech K780 - Versatile and Reliable',
        brand: 'Logitech',
        model: 'K780',
        description: 'The Logitech K780 is a versatile wireless keyboard with support for multiple devices. Its comfortable typing experience and long battery life make it a great choice for users who need a reliable keyboard for both work and personal use.',
        type: 'Wireless',
        switches: 'Membrane',
        backlight: 'None',
        price: '$79'
      }
      // ... other keyboards
    ]
  },
  {
    category: 'Gaming Chair',
    items: [
      {
        title: 'Secretlab Omega - Ultimate Comfort',
        brand: 'Secretlab',
        model: 'Omega',
        description: 'The Secretlab Omega is an ergonomic gaming chair designed for comfort during long gaming sessions. With a racing-style design and adjustable features, it provides excellent support and a high level of customization for an optimal seating experience.',
        type: 'Racing',
        material: 'PU Leather',
        recline: '165 degrees',
        price: '$399'
      },
      {
        title: 'Herman Miller Embody - Superior Ergonomics',
        brand: 'Herman Miller',
        model: 'Embody',
        description: 'Herman Miller Embody is a high-end ergonomic chair offering superior comfort and support. Designed for extended periods of use, it features advanced ergonomics and build quality, making it an ideal choice for those who prioritize health and comfort.',
        type: 'Ergonomic',
        material: 'Fabric',
        recline: 'Yes',
        price: '$1,595'
      }
      // ... other gaming chairs
    ]
  }
];
