CREATE TABLE fundamentus (
    id serial PRIMARY KEY,
    papel character varying NOT NULL,
    cotacao  DECIMAL(20,2) NOT NULL,
    pl  DECIMAL(20,2) NOT NULL,
    pvp  DECIMAL(20,2) NOT NULL,
    psr  DECIMAL(20,2) NOT NULL,
    div_yield  DECIMAL(20,4) NOT NULL,
    p_ativo  DECIMAL(20,2) NOT NULL,
    p_cap_giro  DECIMAL(20,2) NOT NULL,
    p_ebit  DECIMAL(20,2) NOT NULL,
    p_ativ_circ_liq  DECIMAL(20,2) NOT NULL,
    ev_ebit  DECIMAL(20,2) NOT NULL,
    ev_ebitda  DECIMAL(20,2) NOT NULL,
    mrg_ebit  DECIMAL(20,4) NOT NULL,
    margem_liquida  DECIMAL(20,4) NOT NULL,
    liquidez_corrente  DECIMAL(20,2) NOT NULL,
    roic  DECIMAL(20,4) NOT NULL,
    roe  DECIMAL(20,4) NOT NULL,
    liq_dois_meses  DECIMAL(20,2) NOT NULL,
    patrimonio_liq  DECIMAL(20,2) NOT NULL,
    div_brut_patri  DECIMAL(20,2) NOT NULL,
    cresc_rec_cinco_anos  DECIMAL(20,4) NOT NULL
);

COMMENT ON COLUMN fundamentus.div_yield IS '%';
COMMENT ON COLUMN fundamentus.mrg_ebit IS '%';
COMMENT ON COLUMN fundamentus.margem_liquida IS '%';
COMMENT ON COLUMN fundamentus.roic IS '%';
COMMENT ON COLUMN fundamentus.roe IS '%';
COMMENT ON COLUMN fundamentus.cresc_rec_cinco_anos IS '%';