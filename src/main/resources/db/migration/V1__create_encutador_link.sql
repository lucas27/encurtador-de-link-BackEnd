CREATE TABLE encurtador_link (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    url_original VARCHAR(255) NOT NULL,
    url_encurtada VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);